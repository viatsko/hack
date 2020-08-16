# Enter your code here
def mask_article(string, words)
  words.each {|word|
    string = string.gsub(word, '<strike>' + word + '</strike>')
  }
  string
end

def strike(str)
  '<strike>' + str + '</strike>'
end