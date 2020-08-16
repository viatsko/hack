
const ALPHABET = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_-';

const URLS = {};

const genrand = () => {
    let result = '';
    
    for (let i = 0; i < 6; i++) {
        result += ALPHABET.charAt(Math.floor(Math.random() * ALPHABET.length));
    }
    
    return result;
}

const encode = longUrl => {
    const shortUrl = genrand();
    
    while(URLS[shortUrl]) {
        shortUrl = genrand();
    }

    URLS[shortUrl] = longUrl;
    
    return shortUrl;
};

const decode = shortUrl => {
    return URLS[shortUrl];
};
