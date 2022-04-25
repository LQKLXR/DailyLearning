# 力扣刷题记录

## 20200417 最常见的单词

```text
MostCommonWord.java
https://leetcode-cn.com/problems/most-common-word/
预处理 + HashMap去重计数 + HashSet排除黑名单
```
## 20200418 字典序排数

```text
LexicalOrder.java
https://leetcode-cn.com/problems/lexicographical-numbers/submissions/
深度优先搜索
```
## 20200420 文件的最长绝对路径
```text
LengthLongestPath.java
https://leetcode-cn.com/problems/longest-absolute-file-path/
把文件分层：一层、二层、三层。
用栈来存储每一层的文件名。
根据当前层和上一层的层数差异，调整栈里面的内容。
遇到文件，就统计全路径名称，与当前最常路径做对比。
```
## 20200421 山羊拉丁文
```text
ToGoatLatin.java
https://leetcode-cn.com/problems/goat-latin/
拆分字符串慢慢处理即可
```

## 20200424 二进制间距
```text
BinaryGap.java
https://leetcode-cn.com/problems/binary-gap/
位运算逐位往右移，统计上次出现1的坐标，做差，取最大差
```

## 20220425 随机数索引
```text
RandomIndex.java
https://leetcode-cn.com/problems/random-pick-index/
用水塘抽样算法，从一个N长度的数组中，随即返回一个值等于target的下标

【重要】水塘抽样算法
```