// Beats 100% of C submissions.

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2) {
    
    if(l1 == NULL && l2 == NULL) return NULL;
    
    // Head is just a placeholder node
    struct ListNode *head = malloc(sizeof(struct ListNode)), *cur = head;
   
    while(l1 && l2) {
        if(l1->val <= l2->val) {
            cur->next = l1; l1 = l1->next;
            cur = cur->next;
        } else {
            cur->next = l2; l2 = l2->next;
            cur = cur->next;
        }
    }
    
    cur->next = l1 ? l1 : l2;
    return head->next;   
}
