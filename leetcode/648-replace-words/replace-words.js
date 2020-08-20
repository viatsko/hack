
class Trie {
    constructor() {
        this.trie = {};
    }
    
    insert(word) {
        let node = this.trie;
        
        for (let i = 0; i < word.length; i++) {
            if (!node[word[i]]) {
                node[word[i]] = {};
            }
            
            node = node[word[i]];
        }
        
        node['$'] = true;
    }
    
    shortest(word) {
        let node = this.trie;
        
        let path = '';
        
        for (let i = 0; i < word.length; i++) {
            if (!node[word[i]]) {
                node[word[i]] = {};
            }
            
            node = node[word[i]];
            
            path += word[i];
            
            if (node['$']) {
                return path;
            }
        }
        
        return false;
    }
}

const replaceWords = (dict, sentence) => {
    const trie = new Trie();
    
    for (const word of dict) {
        trie.insert(word);
    }
    
    return sentence.split(' ').map((word) => {
        const shortest = trie.shortest(word);
        
        if (shortest !== false) {
            return shortest;
        }
        
        return word;
    }).join(' ');
}
