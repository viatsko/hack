function groupingDishes(dishes) {
    const ingredients = {};

    for (const dish of dishes) {
        const title = dish.shift();

        for (const ingredient of dish) {
            if (!Object.prototype.hasOwnProperty.call(ingredients, ingredient)) {
                ingredients[ingredient] = [];
            }

            ingredients[ingredient].push(title);
        }
    }

    const result = [];

    const keys = Object.keys(ingredients);

    keys.sort();

    keys.forEach((ingredient) => {
        const ingredientAndDishes = [ingredient];

        if (ingredients[ingredient].length < 2) {
            return true;
        }

        ingredients[ingredient].sort();

        Array.prototype.push.apply(ingredientAndDishes, ingredients[ingredient]);

        result.push(ingredientAndDishes);
    });

    return result;
}
