package tries;

// dictionary;
// add,search and remove


// here if we use hashmap then complexity is O(1) in avg case. and it is independent of
// entries in the hashmap..
// in hashmap we calculate hashcode for this takes time equal to word length for every opn.
class TrieNode {

    char data;
    boolean isTerminating;
    TrieNode children[];

    public TrieNode(char data) {

        this.data = data;
        isTerminating = false;
        children = new TrieNode[26];

    }


}


public class impl {

    TrieNode root;

    public impl() {

        root = new TrieNode('\0');
    }


    private void add(TrieNode root, String word) {


        if (word.length() == 0) {

            root.isTerminating = true;
            return;
        }


        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
        }

        add(child, word.substring(1));

    }



    public void add(String word) {
        add(root, word);


    }


    public void remove(TrieNode root, String word) {

        if (word.length() == 0) {
            root.isTerminating = false;
            return;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }


        remove(child, word.substring(1));

        // after all is done terminating is set to false here char are still
        // present in the trie in order to delete those parent will decide whether to delete
        // child or not.
        // only if it non terminal and no. of children is zero...
        if (!child.isTerminating) {

            int numChild = 0;

            for (int i = 0; i < 26; i++) {
                // count no. of child..
                if (child.children[i] != null) {
                    numChild++;
                }
            }

            if (numChild == 0) {
                // delete child now..
                // here garbage collector in java free up  the node not referred by any.
                // here node is referred by root children node array so we set to null/
                root.children[childIndex] = null;
                // child = null; not needed. scope is in func.
            }
        }


    }



}
