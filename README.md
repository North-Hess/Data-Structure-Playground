# Static Array/Dynamic Array:
Fixed length container containing n elements indexable from the range [0, n-1].

Indexable means that each slot/index in the array can be referenced with a number. Zero-based.

When and Where-
1. Storing and accessing sequential data
2. Temporarily storing object
3. Used by IO routines as buffers
4. Lookup tables and inverse lookup tables
5. Can be used to return multiple values from a function
6. Used in dynamic programming to cache answers to subproblems

Complexity-
            Static  Dynamic
Access      O(1)    O(1)
Search      O(n)    O(n)
Insertion   N/A     O(n)
Appending   N/A     O(1)
Deletion    N/A     O(n)


# Singly and Doubly Linked Lists:
Sequential list of nodes that hold data which point to
other nodes also containing data. Last node has null
reference signaling the list is done.

Singly only hold a reference to the next node
Uses less memory and simpler implementation but cannot easily access previous elements

Doubly hold a reference to the next and previous node
Can be traversed backwards but takes 2x memory

Terminology-
Head: The first node in a linked list
Tail: The last node in a linked list
Pointer: Reference to another node
Node: An object containing data and pointer(s)

When and Where-
1. Used in many List, Queue & Stack implementations
2. Great for creating circular lists
3. Can easily model real world object such as trains
4. Used in separate chaining, which is present in certain Hashtable implementations to deal with hashing collisions
5. Often used in the implementation of adjacency lists for graphs

Complexity-
                    Singly  Doubly    
Search              O(n)    O(n)
Insert head         O(1)    O(1)
Insert tail         O(1)    O(1)
Remove at head      O(1)    O(1)
Remove at tail      O(n)    O(1)
Remove in middle    O(n)    O(n)  

