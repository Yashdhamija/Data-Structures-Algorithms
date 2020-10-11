# Data Structures & Algorithms

Solutions to some problems

<strong>1. Merge Two Sorted Lists</strong>

Q. Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

Input: , 0
Output: 0


<strong>2. Deleting a node in Binary Search Tree (BST)</strong>

Q. Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
-> Basically, the deletion can be divided into two stages:
  - Search for a node to remove.
  - If the node is found, delete the node.
Further need to consider two cases when replacing/deleting. The deletion node: 1. has no children 2. has only one child (left or right).
