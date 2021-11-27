package com.solutions.a20211127a;

import java.util.ArrayList;
import java.util.List;

// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
/**
 *          4
 *         /  \
 *        2    6
 *      /  \   / \
 *     1    3 5   7
 */

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


//Definition for singly-linked list.
class ListNode {
public int val;
public ListNode next;
ListNode(int x) { val = x; next = null; }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode a) {
        ListNode currentNode = a;
        List<TreeNode> nodes = new ArrayList<>();
        
        while (currentNode != null) {
            TreeNode node = new TreeNode(currentNode.val);
            nodes.add(node);
            currentNode = currentNode.next;
        }

        return buildBST(nodes);
    }

    private TreeNode buildBST(List<TreeNode> nodes) {
        TreeNode mainNode;
        if (nodes.size() > 1) {
            int halfNode = nodes.size() / 2;
            mainNode = nodes.get(halfNode);
            mainNode.left = buildBST(nodes.subList(0, halfNode));
            if (halfNode + 1 < nodes.size()) {
                mainNode.right = buildBST(nodes.subList(halfNode + 1, nodes.size()));
            }
        } else {
            mainNode = nodes.get(0);
        }

        return mainNode;
    }
}
