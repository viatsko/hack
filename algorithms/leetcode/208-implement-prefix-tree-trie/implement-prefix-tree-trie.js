
class Trie {
    /**
     * Constructor
     */
    constructor() {
        this.tree = {};
    }
    
    /**
     * Inserts a word into the trie. 
     * @param {string} word
     * @return {void}
     */
    insert(word) {
        let pointer = this.tree;
        
        for (let i = 0; i < word.length; i++) {
            if (!pointer[word[i]]) {
                pointer[word[i]] = {};
            }
            
            pointer = pointer[word[i]];
        }
        
        pointer['$'] = {};
    }
    
    /**
     * Returns if the word is in the trie. 
     * @param {string} word
     * @return {boolean}
     */
    search(word) {
        let pointer = this.tree;
        
        for (let i = 0; i < word.length; i++) {
            if (!pointer[word[i]]) {
                return false;
            }
            
            pointer = pointer[word[i]];
        }
        
        return !!pointer['$'];
    }
    
    
    /**
     * Returns if there is any word in the trie that starts with the given prefix. 
     * @param {string} prefix
     * @return {boolean}
     */
    startsWith(prefix) {
        let pointer = this.tree;
        
        for (let i = 0; i < prefix.length; i++) {
            if (!pointer[prefix[i]]) {
                return false;
            }
            
            pointer = pointer[prefix[i]];
        }
        
        return true;
    }
}
