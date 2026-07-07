// Last updated: 7/7/2026, 10:58:58 PM
class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];

        // store best index
        int index = -1;
    }

    TrieNode root = new TrieNode();
    String[] words;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        words = wordsContainer;

        // global shortest word
        int bestIdx = 0;

        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[bestIdx].length()) {
                bestIdx = i;
            }
        }

        root.index = bestIdx;

        // build reverse trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }

    private void insert(String word, int idx) {
        TrieNode node = root;

        // reverse insert
        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';

            if (node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }

            node = node.children[ch];

            // update best index
            if (node.index == -1 ||
                words[idx].length() < words[node.index].length()) {

                node.index = idx;
            }
        }
    }

    private int search(String query) {
        TrieNode node = root;

        // reverse search
        for (int i = query.length() - 1; i >= 0; i--) {
            int ch = query.charAt(i) - 'a';

            if (node.children[ch] == null) {
                break;
            }

            node = node.children[ch];
        }

        return node.index;
    }
}