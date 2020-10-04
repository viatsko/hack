public class TextEditor {
    class Node{
        String text;
        Node left;
        Node right;
        int size;
        Node(){
        }
        Node(String s, int size){
            left = null;
            right = null;
            this.size = size;
            this.text = s;
        }
    }

    class Rope{
        Node root;
        Rope(String input){
            buildRope(input);
        }
        Node buildRope(String s){
            int n = s.length();
            if( n<=0){
                return null;
            }
            if(n <= 2){
                return new Node(s, s.length());
            }
            Node node = new Node();
            node.left = buildRope(s.substring(0,n/2));
            node.right = buildRope(s.substring(n/2));
            node.size = s.length();
            return node;
        }

        char index(Node node, int i){
            if(node == null || i > node.size) return 'x';
            if(node.left == null){
                return node.text.charAt(i);
            }
            if(i < node.left.size){
                return index(node.left, i);
            } else {
                return index(node.right, i - node.left.size);
            }
        }

        void concat(String s){
            Node newRoot = new Node();
            newRoot.left = root;
            newRoot.right = buildRope(s);
            newRoot.size = newRoot.left.size + newRoot.right.size;
            root = newRoot;
        }
        /*function adjust() {
  if (typeof this._value != 'undefined') {
    if (this.length > Rope.SPLIT_LENGTH) {
      var divide = Math.floor(this.length / 2);
      this._left = new Rope(this._value.substring(0, divide));
      this._right = new Rope(this._value.substring(divide));
      delete this._value;
    }
  } else {
    if (this.length < Rope.JOIN_LENGTH) {
      this._value = this._left.toString() + this._right.toString();
      delete this._left;
      delete this._right;
        }
        }
    }
*/
        void reBalence(){

        }
        void insert (Node root, int i, char target){
            if(root.text != ""){

            } else {
                if(i < root.left.size){
                    insert(root.left, i, target);
                } else {
                    insert(root.right, i - root.left.size, target);
                }
                root.size = root.left.size + root.right.size;
            }
            reBalence();
        }
        void delete(Node root, int start, int end){
            if(root.text != ""){

            } else {
                if(end <= root.left.size){
                    delete(root.left, start, end);
                }  else if(start > root.left.size){
                    delete(root.right, start - root.left.size, end - root.left.size);
                }  else{

                }
            }
        }
        Node subString(Node n, int start, int length){
            if(n.left == null){
                Node newNode = new Node();
                newNode.left = null;
                newNode.text = n.text.substring(start);
                newNode.size = length;
                return newNode;
            } else if (start + length <= n.left.size){
                return subString(n.left, start, length);
            } else if (n.left.size < start){
                return subString(n.right, start - n.left.size, length - n.left.size );
            } else {
                Node newNode = new Node();
                newNode.left = subString(n.left, start, n.left.size - length);
                newNode.right = subString(n.right, 0, length - (n.left.size - start));
                newNode.size = length;
                return newNode;
            }
        }



    }

}
 