# LeetCode-Codes-and-Notes
-  Here is a record of my learning on LeetCode.

### CATALOG

| No.  | Date       | Title                                                        | Tag                                       | Notes                                                        |
| ---- | ---------- | ------------------------------------------------------------ | ----------------------------------------- | ------------------------------------------------------------ |
| 1    | 2020.08.06 | [Two Sum](Notes/Two-Sum.md)                                  | `Array` `Hash Map`                        | 1. **加快查找的速度**：哈希表牺牲空间换时间；<br>2. **泛型**，避免集合使用中的强制类型转换. |
| 2    | 2020.08.06 | [Reverse Linked List](Notes/Reverse-Linked-List.md)          | `LinkedList` `recursion` `iteration`      | 1. **在普遍解法中包含特殊情况**，利用 `0` 与 `null`；<br>2. **一种单链表的反向操作**，`head.next.next = head;` ；<br>3. **变量名的指代性**，`prev` `curr` `next` `temp` . |
| 3    | 2020.08.07 | [包含min函数的栈](Notes/minStack.md)                         | `stack` `double-stack` `stack-plus`       | 1. **double stack**: 维护一个辅助栈来拓展功能；<br>2. **stack plus**: 设计一个增强型栈，它同时存储基础数据和功能性数据. |
| 4    | 2020.08.08 | [Moving Average from Data Stream](Notes/Moving-Average-from-Data-Stream.md) | `Circular queue`                          | 1. **多种情形的统一**：使用 `Math.max()` `Math.min()` ；<br>2. **数据复用提高效率**：如加数重复的求和运算. |
| 5    | 2020.08.11 | [Subtree of Another Tree](Notes/Subtree-of-Another-Tree.md)  | `Recursion` `Tree`                        | 1. **判断语句中的逻辑简化**；<br>2. **代码风格的启发**：多个单 `if` 语句比 `if-elseif-else` 语句的可读性强；尽量使代码“头轻脚重”. |
| 6    | 2020.08.12 | [Diameter of Binary Tree](Notes/Diameter-of-Binary-Tree.md)  | `Tree` `Recursion`                        | 1. **在递归方法中更新外部变量**：类中的字段可以被所有的方法访问，这为其提供了基础. |
| 7    | 2020.08.12 | [Binary Tree Right Side View](Notes/Binary-Tree-Right-Side-View.md) | `Tree` `traverse`                         | 1. **在遍历中记录当前深度**.                                 |
| 8    | 2020.08.13 | [重建二叉树](Notes/Reconstruct-A-Binary-Tree.md)             | `tree` `recursion ` `hash map`            | 1. **`Arrays.copyOfRange()`的效率低**：尽量通过传递元素索引范围的方式实现数组切片，而不是 `Arrays.copyOfRange()` ；<br>2. **递归算法要直接**：尽量直接地实现递归逻辑，不要绕弯（如借助外部变量）； <br>3. **非重复元素的比较、查找用哈希表**. |
| 9    | 2020.08.13 | [二叉树中和为某一值的路径](Notes/Path-Sum.md)                | `tree` `backtrace`                        | 1. **使用构造器完成 `copy `** ：`List.copyOf()` 依然面临效率问题.  `LinkList` 的构造器可以以一个集合为输入，故可用来替代 `copy` <br> 2. **`Stack` 主要适合元素为整数的情况**： `Stack` 在元素为整数时效率更高，非整数时用 `LinkedList` 为佳.<br> 3. **递归尽量拥有简明的基准条件**，哪怕结果是需要多调用一次 |
| 10   | 2020.08.13 | [ 从上到下打印二叉树I+II+III](Notes/Level-Order.md)          | `tree` `BFS`                              | 1. `Integer[]` 转换成 `int []` 时，循环快于 `stream().mapToInt(Integer::intValue).toArray()` <br>2. 可以利用已输出的中间结果来判断当前状态：在遍历中，利用`List<List<Integer>> ans.size()` 判断当前的层数. |
| 11   | 2020.08.14 | [二叉搜索树的第k大节点](Notes/Kth-Largest-Of-Search-Tree.md) | `tree` `backtracing` `list`               | 1. **借助外部变量来增强递归算法的功能**.                     |
| 12   | 2020.08.15 | [二叉树的最近公共祖先](Notes/Lowest-Common-Ancestor.md)      | `tree ` `Postorder traversal`             | 1. **充分分析题目条件，首先在逻辑上对诸多情况进行简化**：比如在寻找最低公共祖先时，若题目告知输入的节点必存在于树中，则**可不必同时找到两个节点**. |
| 13   | 2020.08.16 | [对称的二叉树](Notes/Symmetric-Tree.md)                      | `Tree` `Recursion` `Iteration`            | 1. **借助队列是将递归算法改为迭代算法的常见方式**.<br>2. **`LinkList` 允许 `null` 入队** |
| 14   | 2020.08.18 | [合并两个排序的链表](Notes/MergeTwoList.md)                  | `divide-and-conquer` `linked list` `sort` | 1. **借助头节点来返回最终的链表**.                           |

