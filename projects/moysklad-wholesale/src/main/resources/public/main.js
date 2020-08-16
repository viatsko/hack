jQuery(function($) {
    var externalCodes;

    var QUANTITY_INPUT_SELECTOR = 'input[id^=\'quantity-\']';

    var table = $('#wholesale-table');

    var totalPrice = $('#total-price');

    var submissionForm = $('#formSubmit');

    var orderContactName = $('#order-contact-name');

    var orderPhone = $('#order-phone');

    var orderEmail = $('#order-email');

    var orderCity = $('#order-city');

    var orderAddress = $('#order-address');

    var orderDescription = $('#order-description');

    var total = 0;

    try {
        externalCodes = JSON.parse(window.localStorage.getItem('e'));
    } catch (e) {
        // Ignored
    }

    if (!externalCodes) {
        externalCodes = {};
    } else if (Object.keys(externalCodes).length > 0) {
        for (var code in externalCodes) {
            if (externalCodes.hasOwnProperty(code)) {
                var count = externalCodes[code];

                if (count > 0) {
                    table.find('input[id="quantity-' + code + '"]').val(parseInt(count, 10));
                }
            }
        }
    }

    function updateTotalPriceElement() {
        totalPrice.html(total.toFixed(2));
    }

    function reinitializeExternalCodesObject() {
        externalCodes = {};

        table.find(QUANTITY_INPUT_SELECTOR).each(function() {
            var id = $(this).attr('id').replace(/^quantity-/, '');

            externalCodes[id] = parseInt($(this).val(), 10);

            if (externalCodes[id] !== 0) {
                var priceStr = '' + $(this).data('price');
                var price = parseFloat(priceStr.replace(/,/, ''));

                var tmp = parseFloat(externalCodes[id] * price);

                total += !isNaN(tmp) ? tmp : 0;
            }
        });
    }

    function setupEventHandlers() {
        table.on('change input', QUANTITY_INPUT_SELECTOR, function () {
            total = 0;

            reinitializeExternalCodesObject();

            window.localStorage.setItem('e', JSON.stringify(externalCodes));

            updateTotalPriceElement();
        });

        submissionForm.on('submit', function(e) {
            e.preventDefault();

            var order = {};

            for (var code in externalCodes) {
                if (externalCodes.hasOwnProperty(code) && (externalCodes[code] > 0)) {
                    order[code] = externalCodes[code];
                }
            }

            var data = {
                contactName: orderContactName.val(),
                phone: orderPhone.val(),
                email: orderEmail.val(),
                city: orderCity.val(),
                address: orderAddress.val(),
                description: orderDescription.val(),
                order: JSON.stringify(order)
            };

            $.post(
                '/submitOrder',
                data
            ).done(function() {
                localStorage.removeItem('e');
                window.location.href = '/thankYou';
            });
        });
    }

    reinitializeExternalCodesObject();
    setupEventHandlers();
    updateTotalPriceElement();
});
