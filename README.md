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
| 6    | 2020.08.12 | [Diameter of Binary Tree](Notes/Diameter-of-Binary-Tree.md)  | `Tree` `Recursion`                        | 1. **在递归方法中更新外部变量**：类中的字段可以被所有的方法访问，为此提供了基础. |
| 7    | 2020.08.12 | [Binary Tree Right Side View](Notes/Binary-Tree-Right-Side-View.md) | `Tree` `traverse`                         | 1. **在遍历中记录当前深度**.                                 |
| 8    | 2020.08.13 | [重建二叉树](Notes/Reconstruct-A-Binary-Tree.md)             | `tree` `recursion ` `hash map`            | 1. **`Arrays.copyOfRange()`的效率低**：尽量通过传递元素索引范围的方式实现数组切片，而不是 `Arrays.copyOfRange()` ；<br>2. **递归算法要直接**：尽量直接地实现递归逻辑，不要绕弯（如借助外部变量）； <br>3. **非重复元素的比较、查找用哈希表**. |
| 9    | 2020.08.13 | [二叉树中和为某一值的路径](Notes/Path-Sum.md)                | `tree` `backtrace`                        | 1. **使用构造器完成 `copy `** ：`List.copyOf()` 依然面临效率问题.  `LinkList` 的构造器可以以一个集合为输入，故可用来替代 `copy` <br> 2. **`Stack` 主要适合元素为整数的情况**： `Stack` 在元素为整数时效率更高，非整数时用 `LinkedList` 为佳.<br> 3. **递归尽量拥有简明的基准条件**，哪怕结果是需要多调用一次 |
| 10   | 2020.08.13 | [ 从上到下打印二叉树I+II+III](Notes/Level-Order.md)          | `tree` `BFS`                              | 1. `Integer[]` 转换成 `int []` 时，循环快于 `stream().mapToInt(Integer::intValue).toArray()` <br>2. 可以利用已输出的中间结果来判断当前状态：在遍历中，利用`List<List<Integer>> ans.size()` 判断当前的层数. |
| 11   | 2020.08.14 | [二叉搜索树的第k大节点](Notes/Kth-Largest-Of-Search-Tree.md) | `tree` `backtracing` `list`               | 1. **借助外部变量来增强递归算法的功能**.                     |
| 12   | 2020.08.15 | [二叉树的最近公共祖先](Notes/Lowest-Common-Ancestor.md)      | `tree ` `Postorder traversal`             | 1. **充分分析题目条件，首先在逻辑上对诸多情况进行简化**：比如在寻找最低公共祖先时，若题目告知输入的节点必存在于树中，则**可不必同时找到两个节点**. |
| 13   | 2020.08.16 | [对称的二叉树](Notes/Symmetric-Tree.md)                      | `Tree` `Recursion` `Iteration`            | 1. **借助队列是将递归算法改为迭代算法的常见方式**.<br>2. **`LinkList` 允许 `null` 入队** |
| 14   | 2020.08.18 | [合并两个排序的链表](Notes/MergeTwoList.md)                  | `divide-and-conquer` `linked list` `sort` | 1. **借助头节点来返回最终的链表**.                           |
| 15   | 2020.08.19 | [滑动窗口的最大值](Notes/Max-Sliding-Window.md)              | `Deque` `slidingWindow`                   | 1. **除了实际运行时间，时间复杂度也是一个重要的分析角度**：实际运行时间长者可能拥有更低的时间复杂度. <br>2. **双向队列适合用于设计滑动窗口.** |
| 16   | 2020.08.21 | [Reverse Words in a String](Notes/Reverse-Words-In-A-String.md) | `string`                                  | 1. **内置方法达到了更快的速度**（如 `String.trim()` `String.split()`），体现了“不要自己造轮子”的正确性，但面试中应避免在核心算法处使用内置方法。 |
| 17   | 2020.08.21 | [把字符串转换成整数](Notes/String-To-Int.md)                 | `string` `char`                           | 1. **字符运算**：不使用 `map` ，而是用字符运算来实现数字字符到整数的转换；<br>2. **溢出监测**：使用 `ans > boundary || ans == boundary && curr> 7`；<br>3. **字符运算**：使用 `'+'` `'-'` `'0'` 而不是 `43` `45` `48` ，这样能提高代码的可读性. |
| 18   | 2020.09.11 | [把数组排成最小的数](Notes/Min-Number-Formed-By-Strings.md)  | `string` `sort`                           | 1. **字符串数组转字符串**：`StringBuilder` `.append()` `.toString`，速度快于 `String.join("",strs)` ； <br>2. **拓展内置的排序**：直接修改 `Array.sort(arr, Comparator)` 的比较器参数，是一种比较巧妙的排序拓展方法. |
| 19   | 2020.09.16 | [两个链表的第一个公共节点](Notes/Get-Intersection-Node.md)   | `tree` `double pointer`                   | 1. **一个关于两个单链表的技巧**：从A的尾跳到B的头，从B的尾跳到A的头 |
| 20   | 2020.09.16 | [复杂链表的复制](Notes/Copy-Random-List.md)                  | `linked list` `hash map`                  | 1. **递归中的状态理解**：递归开始向上返回结果前已经完成链表的遍历。 |
