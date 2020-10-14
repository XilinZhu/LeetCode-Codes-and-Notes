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
| 18   | 2020.09.11 | [把数组排成最小的数](Notes/Min-Number-Formed-By-Strings.md)  | `string` `sort`                           | 1. **字符串数组转字符串**：`StringBuilder` `.append()` `.toString`，速度快于 `String.join("",strs)` ； <br>2. **拓展内置的排序**：直接修改 `Array.sort(arr, Comparator)` 的比较器参数，是一种比较巧妙的排序拓展方法；<br>3. **多种排序算法** |
| 19   | 2020.09.16 | [两个链表的第一个公共节点](Notes/Get-Intersection-Node.md)   | `tree` `double pointer`                   | 1. **一个关于两个单链表的技巧**：从A的尾跳到B的头，从B的尾跳到A的头 |
| 20   | 2020.09.16 | [复杂链表的复制](Notes/Copy-Random-List.md)                  | `linked list` `hash map`                  | 1. **递归中的状态理解**：递归开始向上返回结果前已经完成链表的遍历。 |
| 21   | 2020.09.22 | [II. 队列的最大值](Notes/Max-Queue.md)                       | `Deque` `Queue`                           | 1. **Integer不可以直接比较！**                               |
| 22   | 2020.09.23 | [第一个只出现一次的字符](Notes/First-Uniq-Char.md)           | `HashMap` `LinkedHashMap`                 | 1. `String` `foreach` **需要先** `String.toCharArray()`      |
| 23   | 2020.09.23 | [最长不含重复字符的子字符串](Notes/Length-Of-Longest-Substring.md) | `HashMAp` `Double-Pointer`                | 1. **双指针 + `HashMap`加速慢指针更新速度**                  |
| 24   | 2020.09.24 | [两两交换链表中的节点](Notes/Swap-Pairs.md)                  | `LinkedList` `Iteration`                  | 1. **当迭代因需要附加条件而变得复杂时，考虑递归**            |
| 25   | 2020.09.24 | [括号生成](Notes/Generate-Parenthesis.md)                    | `string` `dynamic programming`            | 1. **适合动态规划的题目：初始状态清晰，递推关系可推导，直接求解较困难。**<br>2. **动态规划编程的基本元素**：动态规划数组 `dp[]`，添加进入数组的初始状态，形成每个新状态的代码实现 |
| 26   | 2020.09.24 | [两数相除](Notes/Divide.md)                                  | `Binary search` `Bit operation`           | 动态规划数组 `dp[]` 添加进入数组的初始状态 形成每个新状态的代码实现1. **位运算的应用**：不用乘法，快速得到两个数相乘/除的正负号：`int sign = ( (dividend ^ divisor) < 0) ? -1 : 1;`；<br>2. **位运算的应用**：不用乘法，进行乘二以实现二分法：`temp <<= 1`。 |
| 27   | 2020.09.25 | [旋转数组的最小数字](Notes/min-Array.md)                     | `binary search`                           | 1. **略加变化的二分法**：使用了 `j--` 这一辅助变化来解决元素重复的情况。 |
| 28   | 2020.09.25 | [字符串的排列](Notes/Permutation.md)                         | `Backtracking` `string`                   | 1. **回溯算法模板**：a. **变量**：全局容器、局部容器、深度计数；b. **递归内容**：终止条件、深度优先、回溯向下一广度搜索；c. **要点**：在每次递归的前后作对称的操作，使得总可以回溯到上一层的状态。 |
| 29   | 2020.09.28 | [二进制中1的个数](Notes/Hamming-Weight.md)                   | `Bit-operation` `Math`                    | 1. **利用位运算判断二进制第一位是否为1**：`(n & 1) == 1` ；<br>2. **利用位运算遍历二进制的每一位**：`n >>>= 1` （无符号右移）。 |
| 30   | 2020.09.28 | [数值的整数次方](Notes/My-Pow.md)                            | `Bit-operation` `Math`                    | 1. **利用位运算判断整数能否被2整除**：`(n & 1) == 1` ；<br/>2. **计算幂函数的巧妙思路**。 |
| 31   | 2020.09.28 | [打印从1到最大的n位数](Notes/Print-Numbers.md)               | `Big-Integer-Problem`                     | 1.**使用字符串来实现大数**； <br>2. **利用循环和遍历来避开字符串进位问题** ；<br>3. **除去开头的0** ：当前数字的位数 + 当遍历到全9数字时，从下一个数字开始，位数+1。 |
| 32   | 2020.09.28 | [剪绳子 II](Notes/Cutting-Rope.md)                           | `Big-Integer-Problem` `Math`              | 1. **数学**：每段为3时，乘积最大，为4或2次之； <br>2. **大数求余**：循环求余，$x^a⊙p=[(x^{a−1}⊙p)(x⊙p)]⊙p=[(x^{a−1}⊙p)x]⊙p$，由于都小于$p$，所以简化为 $(x^{a-1}x)⊙p$ |
| 33   | 2020.09.28 | [旋转图像](https://leetcode-cn.com/problems/rotate-image/)   | `Array`                                   | 1. **循环移动位置：**用与移动相反的方向进行赋值，这样可以只使用一个临时变量。 |
| 34   | 2020.09.28 | [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) | `String` `HashMAp`                        | 1. 要使用 `String.valueOf()`， 使用 `toString()` 得到的字符串，即使看起来一样，也不被判定为同一个key |
| 35   | 2020.10.04 | [最小的k个数](Notes/Get-Least-Numbers.md)                    | `quick selection` `heap sort`             | 1. **比较快速排序与堆排序**：堆排序空间复杂度低、可以接收数据流、不改变原始数据；快速排序时间复杂度低、可以就地进行。 |
| 36   | 2020.10.04 | [数字序列中某一位的数字](Notes/Find-Nth-Digit.md)            | `Math` `Big-Integer`                      | 1. **大数问题，使用 `long`**： 因为限制中指出 `0 <= n < 2^31`，而 `int` 的最大值为 `2^31-1` ，所以要考虑使用 `long` <br>2. **长整型转字符串**：注意将数据类型 `long` 转换为字符串时，使用的静态方法 `Long.toString()` 。 |
| 37   | 2020.10.04 | [礼物的最大价值](Notes/Max-Value.md)                         | `dynamic programming`                     | 1. **解题思路简洁，故能顺藤摸瓜得到简洁的代码**：在寻找最大求和路径时，不从前往后看，而是从后往前看，得出每个位置能获得的最大和。 |
| 38   | 2020.10.06 | [平衡二叉树](Notes/Is-Balanced.md)                           | `Balanced-Tree` ` Postorder traversal`    | 1. **树的遍历方式选择**：自顶向下使用先序遍历，自底向上使用后序遍历。 |
| 39   | 2020.10.06 | [II. 和为s的连续正数序列](Notes/Find-Continuous-Sequence.md) | `moving-window`                           | 1. **滑动窗口的状态变量**：滑动窗口通常会利用一个中间变量储存当前状态。这个状态根据窗口的形态变化作有规律的变化，从而不必每次重新计算状态。 |
| 40   | 2020.10.06 | [圆圈中最后剩下的数字](Notes/Last-Remaining.md)              | `自建循环链表` `math`                     | 1. **`ArrayList` 与 `LinkedList` ：**虽然就删除操作本身而言，`LinkedList` 的时间复杂度仅为 $O(1)$，但搜索节点需要花费 $O(N)$ 的时间复杂度。通过比较发现，在 `List.remove(int index)` 的实现上，`ArrayList` 具有更低的时间复杂度。 |
| 41   | 2020.10.06 | [不用加减乘除做加法](Add.md)                                 | `bit-operation`                           | 1.**位运算加法可以不考虑正负号**：计算机系统中，整数是以补码形式保存的，所以作加法的时候不用考虑正负号问题； <br>2. **使用位运算的加法由三部分组成：**计算进位制、计算无进位中间结果，保存当前的进位。循环，直到进位值为 0。 |
| 42   | 2020.10.09 | [构建乘积数组](Notes/Construct-Arr.md)                       | `traversal`                               | 1.**利用两次遍历实现特定元素的剔除**。                       |
| 43   | 2020.10.10 | [实现 strStr()](strStr.md)                                   | `string` `double pointer`                 | 1. **Sunday算法的核心思想**：总是从当前匹配字符串的后一位（暴力搜索中的下一次终点）向前寻找下一次的起点。 |

## Template

### 1. 哈希表

| Problem                     | Notes                      |
| --------------------------- | -------------------------- |
| [Two Sum](Notes/Two-Sum.md) | 空间换时间，既存储又查找。 |
|                             |                            |

### 2. 链表

| Problem                                             | Notes                                                        |
| --------------------------------------------------- | ------------------------------------------------------------ |
| [Reverse Linked List](Notes/Reverse-Linked-List.md) | 递归：从后往前，需要保存原尾节点、避免循环链表；循环：从前往后，需要临时变量 |
|                                                     |                                                              |

### 3. 辅助栈

| Problem                              | Notes                                            |
| ------------------------------------ | ------------------------------------------------ |
| [包含min函数的栈](Notes/minStack.md) | 只需把比当前最小值小的数压入辅助栈，因为后进先出 |
|                                      |                                                  |

### 4. 循环队列

| Problem                                                      | Notes                                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [Moving Average from Data Stream](Notes/Moving-Average-from-Data-Stream.md) | 长度不变；利用 `count` 判断是否队满；每次插入新元素时，妥善处理状态的变化 |
| [圆圈中最后剩下的数字](Notes/Last-Remaining.md)              | 长度不断减小；在 `List.remove(int index)` 的实现上，`ArrayList` 具有更低的时间复杂度 |

### 5. DFS

| Problem                                                      | Notes                                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [Subtree of Another Tree](Notes/Subtree-of-Another-Tree.md)  | 构建判断两棵树是否相等的函数；进行后序递归。                 |
| [Diameter of Binary Tree](Notes/Diameter-of-Binary-Tree.md)  | 经过一个节点的最长路径等于左右子树的最大深度之和加1；利用类变量存储全局信息；后序递归 |
| [Binary Tree Right Side View](Notes/Binary-Tree-Right-Side-View.md) | 每层只有一个节点能被看见，利用数组长度和当前深度的大小关系来推测当前层是否已有点被看见。对于表示“当前”信息的变量，一定要在递归返回前作对称的操作以实现回溯。 |
| [重建二叉树](Notes/Reconstruct-A-Binary-Tree.md)             | 由先序得根节点，进而由中序得到左右子树的节点数量，从而能划分后进行递归。可问：是否有重复元素？ |
| [二叉搜索树的第k大节点](Notes/Kth-Largest-Of-Search-Tree.md) | 按右根左的顺序递归遍历，因为需要记录第 k 大值，所以需要一个外部变量来记录当前为第几大；因为可能在中途返回，所以借助了外部变量来存储结果。注意赋值操作：`if (k == 0) return; if(--k == 0) res = root.val; ` 保证了只有一次赋值，否则递归向上过程中 `res` 会被覆盖。 |

### 6. 子串

| Problem                                                     | Notes                                                        |
| ----------------------------------------------------------- | ------------------------------------------------------------ |
| [Subtree of Another Tree](Notes/Subtree-of-Another-Tree.md) | 先以先序顺序将数序列化，再作字串匹配                         |
| [实现 strStr()](Notes/strStr.md)                            | Sunday算法的核心思想：总是从当前匹配字符串的后一位（暴力搜索中的下一次终点）向前寻找下一次的起点。 |

- [Sunday算法模板](template/Sunday.md)

### 7. 双指针

### 8. 回溯

| Problem                                       | Notes                                                        |
| --------------------------------------------- | ------------------------------------------------------------ |
| [二叉树中和为某一值的路径](Notes/Path-Sum.md) | 在递归前后，一定要注意状态变量的对称，但递归调用间传递的局部变量（如`target`）除外。关于复制状态变量进入结果变量：`ans.add(new LinkedList<>(path));` |
|                                               |                                                              |

### 9. BFS

| Problem                                             | Notes                                                        |
| --------------------------------------------------- | ------------------------------------------------------------ |
| [ 从上到下打印二叉树I+II+III](Notes/Level-Order.md) | 基本的BFS：循环+链表；考虑按层打印，则维护一个变量，记录当前层的剩余节点数，并在进入下一层前更新；考虑之字形打印，则在存储当前层节点之前，通过答案数组的 `size()` 来推断当前是否为奇数层，若是，则先反转 `Collection.reverse()` |
|                                                     |                                                              |