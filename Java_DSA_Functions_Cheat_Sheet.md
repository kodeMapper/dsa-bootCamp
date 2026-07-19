# The Complete Java DSA Functions Cheat Sheet
### For Coding Interviews, Online Assessments & Competitive Programming

> Built for beginners who know Java syntax but want to stop searching for built-in methods while solving DSA problems. Read top to bottom once to learn, then use it as a 15–20 minute revision sheet before every interview or contest.

**How to use this document**
- Sections are arranged from easiest → most advanced.
- Every method/table mentions its **package**, whether it works on **arrays / objects / collections**, and its **time complexity**.
- 🧠 = Memory trick · ⚠️ = Common mistake · 💡 = Interview tip · 📦 = Package

---

## Table of Contents

1. [Arrays](#1-arrays)
2. [Strings](#2-strings)
3. [Characters](#3-characters)
4. [Math Class](#4-math-class)
5. [Collections Framework](#5-collections-framework)
6. [Primitive Data Structures](#6-primitive-data-structures)
7. [Iterators & Loops](#7-iterators--loops)
8. [Utility Classes](#8-utility-classes)
9. [Sorting](#9-sorting)
10. [Searching](#10-searching)
11. [HashMap Tricks](#11-hashmap-tricks)
12. [Queue & Heap Tricks](#12-queue--heap-tricks)
13. [Bit Manipulation Helpers](#13-bit-manipulation-helpers)
14. [Input & Output](#14-input--output)
15. [Frequently Used DSA Templates](#15-frequently-used-dsa-templates)
16. [Constructors — Consolidated Reference](#16-constructors--consolidated-reference)
17. [Java DSA One-Liners](#17-java-dsa-one-liners)
18. [Top 50 Interview Tricks](#18-top-50-interview-tricks)
19. [Top 50 Beginner Mistakes](#19-top-50-beginner-mistakes)
20. [When to Use What?](#20-when-to-use-what)
21. [Top 100 Java DSA Functions — Quick Table](#21-top-100-java-dsa-functions--quick-table)
22. [Ultimate Java DSA Quick Revision Sheet](#22-ultimate-java-dsa-quick-revision-sheet)
23. [Java DSA Contest Toolkit](#23-java-dsa-contest-toolkit)

---

## 1. Arrays

📦 Arrays live in `java.lang` (the type itself) but almost every **utility method** for arrays comes from `java.util.Arrays`.

### 1.1 Declaration & Initialization

```java
int[] a = new int[5];                 // default values: 0
int[] b = {1, 2, 3, 4, 5};            // direct initialization
int[] c = new int[]{1, 2, 3};         // explicit form
int[][] matrix = new int[3][4];       // 2D array, all zeros
int[][] jagged = new int[3][];        // jagged array (rows of different length)
```
⚠️ `new int[5]` gives `int` default `0`, `boolean` default `false`, `Object`/`String` default `null` — beginners often assume garbage values like in C.

### 1.2 Core `Arrays` Class Methods

| Method | Purpose | Works On | Time Complexity |
|---|---|---|---|
| `Arrays.sort(arr)` | Sorts ascending (dual-pivot quicksort for primitives) | primitive/object arrays | O(n log n) |
| `Arrays.sort(arr, from, to)` | Sorts only the range `[from, to)` | both | O(n log n) |
| `Arrays.sort(arr, Comparator)` | Custom sort — **only works on object arrays** (`Integer[]`, not `int[]`) | object arrays | O(n log n) |
| `Arrays.fill(arr, val)` | Fills every index with `val` | both | O(n) |
| `Arrays.fill(arr, from, to, val)` | Fills a sub-range | both | O(n) |
| `Arrays.copyOf(arr, newLen)` | Returns a new resized copy | both | O(n) |
| `Arrays.copyOfRange(arr, from, to)` | Copies a sub-array `[from, to)` | both | O(n) |
| `Arrays.equals(a, b)` | Checks if two arrays have identical elements in order | both | O(n) |
| `Arrays.deepEquals(a, b)` | Checks equality for nested (2D+) arrays | object arrays | O(n·m) |
| `Arrays.toString(arr)` | Human-readable 1D string like `[1, 2, 3]` | both | O(n) |
| `Arrays.deepToString(arr)` | Human-readable string for 2D/nested arrays | object arrays | O(n·m) |
| `Arrays.binarySearch(arr, key)` | Finds index of `key` (array **must be sorted**) | both | O(log n) |
| `Arrays.asList(arr)` | Converts an object array to a fixed-size `List` view | object arrays only | O(1) |
| `Arrays.stream(arr)` | Converts to an `IntStream`/`Stream` for functional ops | both | O(1) (lazy) |
| `Arrays.hashCode(arr)` | Computes a hash code based on contents | both | O(n) |

### 1.3 Sorting Arrays (Ascending & Descending)

**Function**
```java
Arrays.sort(arr);
```
**Purpose:** Sorts a primitive array in ascending order in-place.
**Example**
```java
int[] arr = {5, 2, 9, 1};
Arrays.sort(arr);
// Output: [1, 2, 5, 9]
```
**Time Complexity:** O(n log n) &nbsp;&nbsp; **Space Complexity:** O(1) extra (in-place for primitives)

⚠️ **Common Mistake:** `Arrays.sort(int[], Comparator)` **does not compile** — you cannot pass a comparator to a primitive array. You must box it to `Integer[]` first, which costs extra memory.

**Descending order — 3 ways:**

```java
// Way 1: Box to Integer[], then sort with reverseOrder (most common in interviews)
Integer[] arr = {5, 2, 9, 1};
Arrays.sort(arr, Collections.reverseOrder());

// Way 2: Sort ascending, then reverse manually (works for int[] too)
int[] arr2 = {5, 2, 9, 1};
Arrays.sort(arr2);
for (int i = 0, j = arr2.length - 1; i < j; i++, j--) {
    int t = arr2[i]; arr2[i] = arr2[j]; arr2[j] = t;
}

// Way 3: For a small trick with non-negative ints — negate, sort, negate back
```
🧠 **Memory Trick:** "Box it to reverse it" — primitive arrays can only go ascending with `Arrays.sort`; descending needs `Integer[]` + `Collections.reverseOrder()`.

💡 **Interview Tip:** When sorting `int[][]` (like intervals) by a column descending: `Arrays.sort(intervals, (x, y) -> y[0] - x[0]);` — this works because `intervals` is `int[][]`, an **object array** of `int[]` rows, so comparators are allowed.

### 1.4 Filling Arrays

**Function**
```java
Arrays.fill(dp, -1);
```
**Purpose:** Quickly initializes every cell — extremely common for memoization arrays.
**Syntax:** `Arrays.fill(array, value)` or `Arrays.fill(array, fromIndex, toIndex, value)`
**Example**
```java
int[] dp = new int[10];
Arrays.fill(dp, -1);   // classic memoization init
// Output: [-1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
```
**Time Complexity:** O(n)
💡 For 2D arrays you must loop rows: `for (int[] row : dp) Arrays.fill(row, -1);` — `Arrays.fill` does not go "deep" into nested arrays.

### 1.5 Copying Arrays

| Method | Behavior |
|---|---|
| `Arrays.copyOf(arr, n)` | New array of size `n`; extra slots filled with default values (0/null) |
| `Arrays.copyOfRange(arr, from, to)` | New array with elements `[from, to)` |
| `arr.clone()` | Shallow copy, same length |
| `System.arraycopy(src, srcPos, dest, destPos, len)` | Fastest, low-level copy (used internally by the above) |

```java
int[] a = {1, 2, 3};
int[] b = a.clone();          // [1, 2, 3], independent copy
int[] c = Arrays.copyOf(a, 5); // [1, 2, 3, 0, 0]
```
⚠️ For 2D arrays, `clone()` and `copyOf` are **shallow** — the inner `int[]` rows are still shared references. Clone each row separately if you need a true deep copy.

### 1.6 Comparing Arrays

```java
int[] a = {1, 2, 3};
int[] b = {1, 2, 3};
System.out.println(a == b);              // false (reference comparison)
System.out.println(Arrays.equals(a, b));  // true (value comparison)
```
⚠️ **Common Mistake:** Using `==` or `.equals()` directly on arrays compares references, not contents. Always use `Arrays.equals()` (1D) or `Arrays.deepEquals()` (2D/nested).

### 1.7 Binary Search on Arrays

**Function**
```java
Arrays.binarySearch(arr, key);
```
**Purpose:** Finds the index of `key` in a **sorted** array.
**Example**
```java
int[] arr = {1, 3, 5, 7, 9};
int idx = Arrays.binarySearch(arr, 7); // Output: 3
int miss = Arrays.binarySearch(arr, 4); // Output: negative → -(insertion point) - 1
```
**Time Complexity:** O(log n)
⚠️ If the element is **not found**, it returns `-(insertionPoint) - 1`, not `-1`. To get the insertion point: `int ip = -(result) - 1;`
⚠️ Array **must already be sorted**, or the result is undefined.

### 1.8 Prefix / Suffix Helpers

```java
// Prefix sum — pre[i] = sum of arr[0..i]
int[] pre = new int[n];
pre[0] = arr[0];
for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + arr[i];
// Range sum [l, r] = pre[r] - (l > 0 ? pre[l-1] : 0)

// Suffix sum — suf[i] = sum of arr[i..n-1]
int[] suf = new int[n];
suf[n - 1] = arr[n - 1];
for (int i = n - 2; i >= 0; i--) suf[i] = suf[i + 1] + arr[i];
```
💡 **Common Interview Use:** "Equilibrium index" / "left sum equals right sum" problems, range-sum queries, product-except-self.

### 1.9 Important Traversal Tricks

```java
// Two-pointer from both ends
for (int i = 0, j = arr.length - 1; i < j; i++, j--) { /* ... */ }

// Sliding window
int left = 0;
for (int right = 0; right < arr.length; right++) {
    // expand window with arr[right]
    while (/* window invalid */ false) left++; // shrink
}

// Traverse a 2D matrix in spiral / diagonal / boundary — always track (row, col) bounds:
// top, bottom, left, right pointers, shrinking after each pass.

// Enhanced for-loop vs index-loop:
for (int x : arr) { /* read-only, cannot modify arr in place */ }
for (int i = 0; i < arr.length; i++) { arr[i] *= 2; } // needed to mutate
```
⚠️ You **cannot modify** the underlying array using the enhanced for-loop's variable (`x` is a copy for primitives) — use an index loop when you need to write back.

---

## 2. Strings

📦 `java.lang.String`, `java.lang.StringBuilder`, `java.lang.StringBuffer`

Strings in Java are **immutable** — every "modification" creates a new String object. This is the single most important fact for DSA work with strings.

### 2.1 Declaration & Basics

```java
String s = "hello";
String s2 = new String("hello");     // avoid — creates a redundant object
char[] chars = s.toCharArray();      // most common way to "edit" a string
String back = new String(chars);     // or String.valueOf(chars)
```
⚠️ `s == s2` can be `false` even with the same text, because `new String(...)` forces heap allocation outside the string pool. Always compare strings with `.equals()`, never `==`.

### 2.2 Most-Used String Methods

| Method | Purpose | Time Complexity |
|---|---|---|
| `s.length()` | Number of characters | O(1) |
| `s.charAt(i)` | Character at index `i` | O(1) |
| `s.substring(a)` / `s.substring(a, b)` | Substring from `a` (to `b`, exclusive) | O(n) |
| `s.indexOf(ch/str)` | First index of a char/substring, else -1 | O(n) |
| `s.lastIndexOf(ch/str)` | Last index of a char/substring | O(n) |
| `s.contains(sub)` | Checks if `sub` exists inside `s` | O(n) |
| `s.equals(other)` | Content equality | O(n) |
| `s.equalsIgnoreCase(other)` | Case-insensitive equality | O(n) |
| `s.compareTo(other)` | Lexicographic comparison (negative/0/positive) | O(n) |
| `s.toCharArray()` | Converts to `char[]` for O(1) index writes elsewhere | O(n) |
| `s.split(regex)` | Splits into `String[]` by a regex delimiter | O(n) |
| `s.trim()` / `s.strip()` | Removes leading/trailing whitespace | O(n) |
| `s.replace(a, b)` | Replaces all literal occurrences of `a` with `b` | O(n) |
| `s.toUpperCase()` / `s.toLowerCase()` | Case conversion | O(n) |
| `s.isEmpty()` | True if length is 0 | O(1) |
| `s.isBlank()` | True if empty or only whitespace (Java 11+) | O(n) |
| `s.repeat(n)` | Repeats the string `n` times (Java 11+) | O(n) |
| `String.join(delim, ...)` | Joins strings/list with a delimiter | O(n) |
| `String.valueOf(x)` | Converts any primitive/object to String | O(1)–O(n) |
| `s.chars()` | Returns an `IntStream` of char codes | O(1) lazy |
| `s.matches(regex)` | Full-string regex match | O(n) |
| `s.startsWith(p)` / `s.endsWith(p)` | Prefix/suffix check | O(k) |

### 2.3 StringBuilder — Your Best Friend for DSA

**Function**
```java
StringBuilder sb = new StringBuilder();
```
**Purpose:** Mutable sequence of characters — use this whenever you build a string in a loop, instead of `String += String` (which is O(n) per concatenation → O(n²) total).

| Method | Purpose | Time Complexity |
|---|---|---|
| `sb.append(x)` | Adds `x` (any type) to the end | Amortized O(1) |
| `sb.insert(i, x)` | Inserts at index `i` | O(n) |
| `sb.deleteCharAt(i)` | Removes character at `i` | O(n) |
| `sb.delete(from, to)` | Removes a range | O(n) |
| `sb.reverse()` | Reverses in place | O(n) |
| `sb.charAt(i)` / `sb.setCharAt(i, c)` | Read/write a character | O(1) |
| `sb.toString()` | Converts back to `String` | O(n) |
| `sb.length()` | Current length | O(1) |
| `sb.setLength(n)` | Truncates/pads to length `n` | O(1)/O(n) |

**Example**
```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 5; i++) sb.append(i);
sb.reverse();
System.out.println(sb.toString()); // Output: 43210
```
🧠 **Memory Trick:** "Builder builds, String is stone." Use `StringBuilder` for anything built in a loop; `String` is set once it's created.

⚠️ **Common Mistake:** `sb.reverse().toString()` chaining is fine, but calling `sb.toString()` **inside a loop** repeatedly re-copies the buffer — only call it once, at the end.

### 2.4 StringBuffer (briefly)

`StringBuffer` is identical to `StringBuilder` in API, but every method is `synchronized` (thread-safe). In DSA/competitive programming there is **no multithreading**, so always prefer `StringBuilder` — it's faster with zero downside.

### 2.5 Parsing Numbers

| Method | Purpose |
|---|---|
| `Integer.parseInt(s)` | `String` → primitive `int` |
| `Integer.valueOf(s)` | `String` → `Integer` object (boxed) |
| `Long.parseLong(s)` | `String` → `long` |
| `Double.parseDouble(s)` | `String` → `double` |
| `Integer.toString(n)` | `int` → `String` |
| `Integer.toBinaryString(n)` | `int` → binary string |
| `Integer.toHexString(n)` | `int` → hex string |
| `Integer.toOctalString(n)` | `int` → octal string |
| `Integer.parseInt(s, radix)` | Parses `s` in a given base (e.g., base 2, 16) |

⚠️ **Common Mistake:** `Integer.parseInt("  42")` throws `NumberFormatException` — leading/trailing spaces are not trimmed automatically; call `.trim()` first.
⚠️ `Integer.parseInt` on a string outside `int` range throws `NumberFormatException` — use `Long.parseLong` for big values.

### 2.6 Splitting Strings

```java
String s = "a,b,,c";
String[] parts = s.split(",");        // ["a", "b", "", "c"]  — keeps empty strings by default... 
String[] parts2 = s.split(",", -1);   // ["a", "b", "", "c"]  — explicit "keep trailing empties"
```
⚠️ **Common Mistake:** `"a,b,c,".split(",")` gives `["a","b","c"]` — trailing empty strings are **dropped** unless you pass a negative limit: `.split(",", -1)`.
💡 `s.split("\\s+")` splits on one-or-more whitespace — the standard way to tokenize a line of space-separated integers.

### 2.7 Joining Strings

```java
String joined = String.join(", ", "a", "b", "c");         // "a, b, c"
String joined2 = String.join("-", listOfStrings);         // works with any Iterable<CharSequence>
String csv = list.stream().map(String::valueOf).collect(Collectors.joining(","));
```

### 2.8 Case Conversion & Trimming

```java
s.toUpperCase(); s.toLowerCase();   // full string
Character.toUpperCase(c); Character.toLowerCase(c); // single char — cheaper for loops
s.trim();    // removes ASCII whitespace (space, \t, \n) from both ends
s.strip();   // Unicode-aware version (Java 11+), prefer this in modern code
```

### 2.9 Pattern Matching

```java
import java.util.regex.*;

boolean ok = "abc123".matches("[a-z]+\\d+");   // full match

Pattern p = Pattern.compile("\\d+");
Matcher m = p.matcher("id: 42, age: 7");
while (m.find()) {
    System.out.println(m.group()); // prints 42, then 7
}
```
💡 **Interview Tip:** For "extract all numbers from a string" problems, `Pattern`/`Matcher` is faster to write than manual char-scanning, but manual scanning is often expected to show you understand string traversal — know both.

### 2.10 Common String ↔ DSA Conversions Cheat Table

| From | To | Code |
|---|---|---|
| `String` | `char[]` | `s.toCharArray()` |
| `char[]` | `String` | `new String(chars)` or `String.valueOf(chars)` |
| `String` | `List<Character>` | `s.chars().mapToObj(c -> (char) c).collect(Collectors.toList())` |
| `String` | `int[]` (of space-separated numbers) | `Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray()` |
| `int[]` | `String` (joined) | `Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(","))` |
| `List<String>` | `String[]` | `list.toArray(new String[0])` |

---

## 3. Characters

📦 `java.lang.Character`

`Character` methods are your fastest way to check letter/digit properties without manual ASCII math — but knowing the ASCII math underneath still helps for tricky problems (e.g., `c - 'a'` to get a 0–25 index).

### 3.1 Character Class Methods

| Method | Purpose | Time Complexity |
|---|---|---|
| `Character.isDigit(c)` | True if `c` is a digit `0`–`9` | O(1) |
| `Character.isLetter(c)` | True if `c` is a letter | O(1) |
| `Character.isLetterOrDigit(c)` | True if letter or digit | O(1) |
| `Character.isUpperCase(c)` / `isLowerCase(c)` | Case check | O(1) |
| `Character.isWhitespace(c)` | True for space, tab, newline, etc. | O(1) |
| `Character.isAlphabetic(c)` | True for any Unicode letter | O(1) |
| `Character.toUpperCase(c)` / `toLowerCase(c)` | Converts case | O(1) |
| `Character.getNumericValue(c)` | Digit char → its int value (`'7'` → `7`) | O(1) |
| `Character.compare(a, b)` | Compares two chars numerically | O(1) |

### 3.2 ASCII Conversions (the manual way — very common in interviews)

```java
char c = 'e';
int index = c - 'a';         // 0-based index into a 26-letter alphabet → 4
char back = (char) ('a' + 4); // index → letter → 'e'

int digit = '7' - '0';        // char digit → int value → 7
char digitChar = (char) ('0' + 7); // int → char digit → '7'
```
🧠 **Memory Trick:** "Subtract the base to get the offset." `c - 'a'` is the single most reused line in string/array-hashing problems (e.g., `int[] freq = new int[26]; freq[c - 'a']++;`).

⚠️ **Common Mistake:** Forgetting that `char` arithmetic in Java auto-promotes to `int` — `'a' + 1` is `98` (an int), not `'b'`. You must cast back: `(char) ('a' + 1)`.

### 3.3 Letter / Digit Checks — Quick Reference

```java
if (Character.isLetter(c)) { ... }
if (Character.isDigit(c)) { ... }
if (Character.isLetterOrDigit(c)) { ... }   // classic "alphanumeric palindrome" filter
```
💡 **Common Interview Use:** Valid Palindrome (LeetCode 125) — filter with `isLetterOrDigit`, compare with `toLowerCase`.

### 3.4 Uppercase / Lowercase Conversion

```java
char upper = Character.toUpperCase('a'); // 'A'
char lower = Character.toLowerCase('A'); // 'a'
```

---

## 4. Math Class

📦 `java.lang.Math` — all methods are `static`, called as `Math.methodName(...)`.

### 4.1 Core Methods

| Method | Purpose | Notes |
|---|---|---|
| `Math.min(a, b)` | Smaller of two values | Overloaded for int, long, float, double |
| `Math.max(a, b)` | Larger of two values | Same overloads |
| `Math.abs(x)` | Absolute value | ⚠️ `Math.abs(Integer.MIN_VALUE)` overflows back to `MIN_VALUE`! |
| `Math.pow(base, exp)` | `base^exp` as a **double** | Cast to `(long)` for integer results; use fast power for large exponents |
| `Math.sqrt(x)` | Square root (double) | Returns `NaN` for negative input |
| `Math.cbrt(x)` | Cube root | |
| `Math.ceil(x)` | Rounds up to nearest whole (returns double) | `Math.ceil(7.0/2)` → `4.0` |
| `Math.floor(x)` | Rounds down to nearest whole (returns double) | |
| `Math.round(x)` | Rounds to nearest integer/long | `float` → `int`, `double` → `long` |
| `Math.random()` | Random `double` in `[0.0, 1.0)` | Use `java.util.Random`/`ThreadLocalRandom` for seeded/int randoms |
| `Math.log(x)` | Natural log (base e) | |
| `Math.log10(x)` | Log base 10 | Useful for counting digits: `(int) Math.log10(n) + 1` |
| `Math.exp(x)` | `e^x` | |
| `Math.hypot(x, y)` | `sqrt(x² + y²)` safely (avoids overflow) | Euclidean distance |
| `Math.signum(x)` | Returns -1.0, 0.0, or 1.0 | |
| `Math.floorDiv(a, b)` | Integer division that rounds toward negative infinity | Correct for negative numbers, unlike `/` |
| `Math.floorMod(a, b)` | Modulo that always returns a **non-negative** result (when b > 0) | Fixes Java's `%` sign issue |

**Example — floorMod vs %**
```java
System.out.println(-7 % 3);            // -1  (Java's % keeps the sign of the dividend)
System.out.println(Math.floorMod(-7, 3)); // 2  (mathematically correct modulo)
```
⚠️ **Common Mistake:** Beginners assume `%` in Java behaves like mathematical modulo. It doesn't for negative numbers — use `Math.floorMod` or `((a % m) + m) % m`.

### 4.2 GCD & LCM (not built into Math — but essential)

```java
// GCD — Euclidean algorithm
static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

// LCM — using GCD
static long lcm(int a, int b) {
    return (long) a / gcd(a, b) * b;   // divide first to avoid overflow
}
```
💡 Java 9+ desugars `BigInteger` has `.gcd()` built-in: `BigInteger.valueOf(a).gcd(BigInteger.valueOf(b))` — rarely needed but good to know it exists.
🧠 **Memory Trick:** "LCM = product / GCD" — always divide before multiplying to reduce overflow risk.

### 4.3 Modular Arithmetic Helpers

```java
static final int MOD = 1_000_000_007;

static long addMod(long a, long b) { return ((a % MOD) + (b % MOD)) % MOD; }
static long mulMod(long a, long b) { return ((a % MOD) * (b % MOD)) % MOD; }
static long subMod(long a, long b) { return (((a - b) % MOD) + MOD) % MOD; }

// Modular exponentiation (fast power) — a^b mod MOD
static long power(long a, long b, long mod) {
    long res = 1;
    a %= mod;
    while (b > 0) {
        if ((b & 1) == 1) res = (res * a) % mod;
        a = (a * a) % mod;
        b >>= 1;
    }
    return res;
}

// Modular inverse (when MOD is prime) via Fermat's little theorem
static long modInverse(long a, long mod) { return power(a, mod - 2, mod); }
```
💡 **Common Interview Use:** Problems that ask "return the answer modulo 10^9 + 7" (very common on LeetCode hard problems and Codeforces) require every intermediate addition/multiplication to be taken mod, not just the final answer.

### 4.4 Overflow-Safe Multiplication Tips

```java
int a = 100000, b = 100000;
// int result = a * b;         // ⚠️ overflows! int max is ~2.1 billion, this needs 10 billion
long result = (long) a * b;    // ✅ cast BEFORE multiplying, not after
```
⚠️ **Common Mistake:** `long result = a * b;` still overflows if `a` and `b` are declared `int` — the multiplication happens in `int` precision *before* the assignment widens it. You must cast at least one operand to `long` **before** the `*`.

🧠 **Memory Trick:** "Cast early, not late." When in doubt with products of large ints, always write `(long) a * b`, never `a * b` then assign to long.

| Situation | Safe Pattern |
|---|---|
| Multiplying two `int`s that might exceed 2³¹-1 | `(long) a * b` |
| Sum of array that might exceed `int` range | Use `long sum = 0;` accumulator |
| Comparing without overflow (`a + b > c`) | Rewrite as `a > c - b` |

---

## 5. Collections Framework

📦 Everything below lives in `java.util` unless stated otherwise. All are **generic** — always parameterize them (`List<Integer>`, never a raw `List`).

### 5.1 ArrayList

**Declaration & Initialization**
```java
List<Integer> list = new ArrayList<>();
List<Integer> list2 = new ArrayList<>(100);              // pre-sized capacity (not size!)
List<Integer> list3 = new ArrayList<>(otherCollection);   // copy constructor
List<Integer> fixed = Arrays.asList(1, 2, 3);             // fixed-size, backed by array
List<Integer> mutable = new ArrayList<>(List.of(1, 2, 3)); // fully mutable copy (Java 9+)
```

**Constructors**

| Constructor | When to Use |
|---|---|
| `new ArrayList<>()` | Default, empty list, capacity 10 |
| `new ArrayList<>(int initialCapacity)` | You know roughly how many elements will be added — avoids resizing overhead |
| `new ArrayList<>(Collection<? extends E> c)` | Build a list from an existing array/set/list |

**Common Methods**

| Method | Purpose | Time Complexity |
|---|---|---|
| `add(x)` | Appends to end | Amortized O(1) |
| `add(i, x)` | Inserts at index `i` | O(n) |
| `get(i)` | Random access | O(1) |
| `set(i, x)` | Overwrites index `i` | O(1) |
| `remove(int i)` | Removes by **index** | O(n) |
| `remove(Object o)` | Removes first matching **value** | O(n) |
| `size()` | Number of elements | O(1) |
| `isEmpty()` | Checks if size == 0 | O(1) |
| `contains(x)` | Linear search | O(n) |
| `indexOf(x)` | First index of `x`, else -1 | O(n) |
| `clear()` | Empties the list | O(n) |
| `sort(Comparator)` | Sorts in place | O(n log n) |
| `subList(from, to)` | View of a range (backed by original!) | O(1) |

⚠️ **Common Mistake:** `list.remove(2)` removes the element **at index 2**, but `list.remove(Integer.valueOf(2))` removes the **value 2**. This is the #1 ArrayList bug for beginners since `remove(int)` and `remove(Object)` are different overloads.

💡 **Interview Tip:** `subList()` returns a **view**, not a copy — modifying it modifies the original list too. Wrap with `new ArrayList<>(list.subList(a,b))` if you need an independent copy.

### 5.2 LinkedList

**Declaration**
```java
LinkedList<Integer> ll = new LinkedList<>();
Deque<Integer> asDeque = new LinkedList<>();   // often used as a Deque
```
`LinkedList` implements both `List` and `Deque` — it's doubly-linked, so it excels at insert/delete from the ends but is slow for random access.

| Method | Purpose | Time Complexity |
|---|---|---|
| `addFirst(x)` / `addLast(x)` | Insert at either end | O(1) |
| `removeFirst()` / `removeLast()` | Remove from either end | O(1) |
| `getFirst()` / `getLast()` | Peek at either end | O(1) |
| `get(i)` | Random access | O(n) — walks the list! |

⚠️ **Common Mistake:** Using `LinkedList` for random-access-heavy code — `get(i)` is O(n), unlike `ArrayList`'s O(1). Only prefer `LinkedList` when you need frequent insert/delete at both ends (in practice, `ArrayDeque` is almost always faster for that too).

### 5.3 Stack

**Declaration**
```java
Stack<Integer> st = new Stack<>();       // legacy class, synchronized (slower)
Deque<Integer> st2 = new ArrayDeque<>(); // ✅ preferred modern stack in DSA
```

| Method (`Stack`) | Equivalent (`ArrayDeque` as stack) | Purpose |
|---|---|---|
| `push(x)` | `push(x)` | Add to top |
| `pop()` | `pop()` | Remove & return top |
| `peek()` | `peek()` | View top without removing |
| `isEmpty()` | `isEmpty()` | Check if empty |
| `search(x)` | — | 1-based position from top, or -1 |

💡 **Interview Tip:** `Stack` extends `Vector` (synchronized, legacy) — it works correctly but is slower than needed. In modern interviews, use `Deque<Integer> stack = new ArrayDeque<>();` and call `push`/`pop`/`peek` on it exactly the same way.
🧠 **Memory Trick:** "Deque as Stack = push/pop/peek on the front."

### 5.4 Queue (interface)

```java
Queue<Integer> q = new LinkedList<>();   // classic FIFO queue
Queue<Integer> q2 = new ArrayDeque<>();  // faster, preferred
```

| Method | Throws on failure? | Returns special value on failure? | Purpose |
|---|---|---|---|
| `add(x)` | Yes (`IllegalStateException`) | — | Insert |
| `offer(x)` | No | Returns `false` | Insert (preferred — safe) |
| `remove()` | Yes (`NoSuchElementException`) | — | Remove head |
| `poll()` | No | Returns `null` | Remove head (preferred — safe) |
| `element()` | Yes | — | Peek head |
| `peek()` | No | Returns `null` | Peek head (preferred — safe) |

🧠 **Memory Trick:** "offer/poll/peek = polite methods that don't throw." Always prefer them over `add/remove/element` in contest code so you don't crash on an empty queue.

### 5.5 Deque (Double-Ended Queue)

**Declaration**
```java
Deque<Integer> dq = new ArrayDeque<>();     // best general-purpose choice — no capacity limit, fast both ends
```

| Method | Purpose | Time Complexity |
|---|---|---|
| `addFirst(x)` / `offerFirst(x)` | Insert at front | O(1) |
| `addLast(x)` / `offerLast(x)` | Insert at back | O(1) |
| `removeFirst()` / `pollFirst()` | Remove from front | O(1) |
| `removeLast()` / `pollLast()` | Remove from back | O(1) |
| `peekFirst()` / `peekLast()` | View either end | O(1) |

💡 **Common Interview Use:** Sliding Window Maximum (monotonic deque), Palindrome Checker, implementing both a Stack and a Queue with one structure.
⚠️ **Common Mistake:** Using `new Deque<>()` — `Deque` is an **interface**; you must instantiate `ArrayDeque` or `LinkedList`.

### 5.6 PriorityQueue (Min Heap & Max Heap)

**Declaration & Constructors**

| Constructor | Behavior |
|---|---|
| `new PriorityQueue<>()` | Min-heap by natural ordering |
| `new PriorityQueue<>(Comparator)` | Custom order (e.g., max-heap) |
| `new PriorityQueue<>(int initialCapacity)` | Pre-sized min-heap |
| `new PriorityQueue<>(Collection c)` | Heapifies an existing collection — O(n), not O(n log n)! |

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();                         // smallest on top
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // largest on top
PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>((a, b) -> b - a);           // lambda version

// Heap of int[] pairs, sorted by second value ascending
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
```

| Method | Purpose | Time Complexity |
|---|---|---|
| `offer(x)` / `add(x)` | Insert | O(log n) |
| `poll()` | Remove & return the top (min or max) | O(log n) |
| `peek()` | View the top without removing | O(1) |
| `size()` | Number of elements | O(1) |

⚠️ **Common Mistake:** `PriorityQueue` only guarantees the **top** element is smallest/largest — iterating over it (`for (int x : pq)`) does **not** give sorted order. Poll one at a time if you need sorted output.
💡 **Common Interview Use:** Kth Largest Element, Merge K Sorted Lists, Top K Frequent Elements, Dijkstra's algorithm.
🧠 **Memory Trick:** "PQ peeks smallest by default — flip the comparator to peek biggest."

### 5.7 HashMap

**Declaration & Constructors**

| Constructor | Use Case |
|---|---|
| `new HashMap<>()` | Default capacity 16, load factor 0.75 |
| `new HashMap<>(int initialCapacity)` | Know roughly how many keys upfront — avoids resize/rehash cost |
| `new HashMap<>(int initialCapacity, float loadFactor)` | Fine-tune resize threshold (rarely needed) |
| `new HashMap<>(Map m)` | Copy another map |

```java
Map<String, Integer> map = new HashMap<>();
```

| Method | Purpose | Time Complexity (avg) |
|---|---|---|
| `put(k, v)` | Insert/overwrite | O(1) |
| `get(k)` | Retrieve, `null` if absent | O(1) |
| `getOrDefault(k, def)` | Retrieve with a fallback | O(1) |
| `containsKey(k)` | Existence check | O(1) |
| `containsValue(v)` | Linear scan of values | O(n) |
| `remove(k)` | Delete a key | O(1) |
| `keySet()` | View of all keys | O(1) (view) |
| `values()` | View of all values | O(1) (view) |
| `entrySet()` | View of key-value pairs (fastest way to iterate both) | O(1) (view) |
| `putIfAbsent(k, v)` | Insert only if key missing | O(1) |
| `merge(k, v, fn)` | Combine new value with existing (great for counting) | O(1) |
| `computeIfAbsent(k, fn)` | Insert a computed default only if missing | O(1) |
| `computeIfPresent(k, fn)` | Update only if key exists | O(1) |

⚠️ **Common Mistake:** Iterating with `for (String k : map)` doesn't compile — `Map` is not `Iterable`. Use `map.keySet()`, `map.entrySet()`, or `map.values()`.
⚠️ HashMap has **no ordering guarantee** — insertion order, sorted order, nothing. If order matters, use `LinkedHashMap` or `TreeMap`.

### 5.8 HashSet

```java
Set<Integer> set = new HashSet<>();
Set<Integer> set2 = new HashSet<>(list);   // dedupe a list in O(n)
```

| Method | Purpose | Time Complexity |
|---|---|---|
| `add(x)` | Insert (no-op if duplicate) | O(1) avg |
| `remove(x)` | Delete | O(1) avg |
| `contains(x)` | Membership check | O(1) avg |
| `size()` | Count of unique elements | O(1) |
| `retainAll(c)` | Keep only elements also in `c` (set intersection) | O(n) |
| `removeAll(c)` | Remove elements found in `c` (set difference) | O(n) |
| `addAll(c)` | Union with `c` | O(n) |

💡 **Common Interview Use:** Deduplication, "contains duplicate" problems, fast O(1) membership check instead of nested loops.

### 5.9 TreeMap

`TreeMap` is a **Red-Black tree** — keeps keys in sorted order, at the cost of O(log n) instead of O(1) for most operations.

```java
TreeMap<Integer, String> tm = new TreeMap<>();               // natural order
TreeMap<Integer, String> tm2 = new TreeMap<>(Collections.reverseOrder()); // descending
```

| Method | Purpose | Time Complexity |
|---|---|---|
| `firstKey()` / `lastKey()` | Smallest / largest key | O(log n) |
| `floorKey(k)` | Largest key ≤ `k` | O(log n) |
| `ceilingKey(k)` | Smallest key ≥ `k` | O(log n) |
| `lowerKey(k)` | Largest key strictly < `k` | O(log n) |
| `higherKey(k)` | Smallest key strictly > `k` | O(log n) |
| `pollFirstEntry()` / `pollLastEntry()` | Removes & returns smallest/largest entry | O(log n) |
| `headMap(k)` / `tailMap(k)` | Sub-map view before/after `k` | O(log n) |

💡 **Common Interview Use:** "Find the closest smaller/larger element", calendar/interval scheduling, order statistics without building a full segment tree.

### 5.10 TreeSet

Same tree backing as `TreeMap`, but stores only keys (no values).

```java
TreeSet<Integer> ts = new TreeSet<>();
```

| Method | Purpose | Time Complexity |
|---|---|---|
| `first()` / `last()` | Smallest / largest | O(log n) |
| `floor(x)` / `ceiling(x)` | ≤ x / ≥ x | O(log n) |
| `lower(x)` / `higher(x)` | Strictly < x / strictly > x | O(log n) |
| `pollFirst()` / `pollLast()` | Remove smallest/largest | O(log n) |
| `subSet(from, to)` | View of elements in range | O(log n) |

🧠 **Memory Trick:** "Tree = sorted + log n. Hash = unordered + O(1)." Choose based on whether you need order.

### 5.11 LinkedHashMap

Just like `HashMap`, but **preserves insertion order** (or access order, if configured).

```java
Map<Integer, Integer> lhm = new LinkedHashMap<>();  
// with access order (true) — turns it into an LRU-cache-friendly structure
Map<Integer, Integer> lru = new LinkedHashMap<>(16, 0.75f, true);
```
💡 **Common Interview Use:** Implementing an **LRU Cache** — override `removeEldestEntry()` for a one-class LRU solution.

### 5.12 LinkedHashSet

Just like `HashSet`, but preserves insertion order during iteration.
```java
Set<Integer> lhs = new LinkedHashSet<>();
```
💡 Use when you need "unique elements, but in the order I inserted them" — e.g., "first unique character" style problems.

---

## 6. Primitive Data Structures

### 6.1 Arrays (recap for DSA patterns)
Already covered in [Section 1](#1-arrays). Key patterns: two-pointer, sliding window, prefix sum.

### 6.2 Matrix (2D Array)

```java
int[][] matrix = new int[rows][cols];

// Traverse
for (int i = 0; i < rows; i++)
    for (int j = 0; j < cols; j++)
        /* matrix[i][j] */;

// Transpose (square matrix, in place)
for (int i = 0; i < n; i++)
    for (int j = i + 1; j < n; j++) {
        int t = matrix[i][j]; matrix[i][j] = matrix[j][i]; matrix[j][i] = t;
    }

// Rotate 90° clockwise: transpose, then reverse each row
// Directions array — the #1 trick for grid BFS/DFS
int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; // right, left, down, up
for (int[] d : dirs) {
    int nr = r + d[0], nc = c + d[1];
    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) { /* valid neighbor */ }
}
```
🧠 **Memory Trick:** Always keep a `dirs[][]` array for grid problems — it turns 4 nested if-statements into one clean loop.

### 6.3 Prefix Sum

```java
int[] prefix = new int[n + 1];   // 1-indexed prefix, prefix[0] = 0
for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + arr[i];

// sum of arr[l..r] inclusive:
int rangeSum = prefix[r + 1] - prefix[l];
```
💡 **Common Interview Use:** Range Sum Query (immutable), Subarray Sum Equals K (combined with a HashMap of prefix sums).

### 6.4 Difference Array

Used for **range update** queries efficiently (O(1) per update instead of O(n)).

```java
int[] diff = new int[n + 1];
// to add `val` to arr[l..r] inclusive:
diff[l] += val;
diff[r + 1] -= val;
// after all updates, rebuild the actual array with a prefix sum over diff:
int[] result = new int[n];
result[0] = diff[0];
for (int i = 1; i < n; i++) result[i] = result[i - 1] + diff[i];
```
💡 **Common Interview Use:** "Range Addition" (LeetCode 370), flight bookings, corporate flight range updates.

### 6.5 Frequency Array / Counter

```java
int[] freq = new int[26];               // for lowercase letters
for (char c : s.toCharArray()) freq[c - 'a']++;

// General frequency with HashMap (unbounded / non-char keys)
Map<Integer, Integer> freqMap = new HashMap<>();
for (int x : arr) freqMap.merge(x, 1, Integer::sum);
```
🧠 **Memory Trick:** "26 for letters, HashMap for everything else." A fixed-size array is always faster than a HashMap when the key range is small and known (like lowercase letters).

### 6.6 BitSet (if useful)

📦 `java.util.BitSet` — a memory-efficient array of bits, useful for very large boolean arrays (e.g., sieve of Eratosthenes on huge ranges).

```java
BitSet bs = new BitSet(1_000_000);
bs.set(5);           // set bit 5 to true
bs.clear(5);         // set bit 5 to false
boolean b = bs.get(5);
bs.flip(5);          // toggle bit 5
int count = bs.cardinality(); // number of set bits
```
💡 Roughly 8x more memory-efficient than `boolean[]` since it packs bits, useful when array sizes get into the tens of millions.

---

## 7. Iterators & Loops

### 7.1 Enhanced For Loop (for-each)

```java
for (int x : arr) { ... }              // read-only for primitive arrays
for (String s : list) { ... }
for (Map.Entry<String, Integer> e : map.entrySet()) { ... }
```
⚠️ Cannot modify the collection's structure (add/remove) while inside a for-each loop — throws `ConcurrentModificationException`.

### 7.2 Iterator

```java
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    int val = it.next();
    if (val % 2 == 0) it.remove();   // ✅ SAFE way to remove while iterating
}
```
🧠 **Memory Trick:** "Iterator.remove() is the only safe removal during a loop." Directly calling `list.remove()` inside a for-each throws `ConcurrentModificationException`.

### 7.3 ListIterator

Like `Iterator`, but bidirectional and supports `set()` for in-place replacement.
```java
ListIterator<Integer> lit = list.listIterator();
while (lit.hasNext()) {
    int val = lit.next();
    lit.set(val * 2);   // replace current element in place
}
while (lit.hasPrevious()) { int v = lit.previous(); }
```

### 7.4 Map Traversal Methods

```java
// Best & fastest — single pass, both key and value
for (Map.Entry<String, Integer> e : map.entrySet()) {
    String k = e.getKey(); int v = e.getValue();
}

// Keys only
for (String k : map.keySet()) { ... }

// Values only
for (int v : map.values()) { ... }

// Functional style (Java 8+)
map.forEach((k, v) -> System.out.println(k + "=" + v));
```
⚠️ **Common Mistake:** Using `keySet()` then calling `map.get(k)` inside the loop is a common beginner pattern, but it's slower (extra hash lookup per key) than iterating `entrySet()` directly.

### 7.5 Best Traversal Practices

| Situation | Best Choice |
|---|---|
| Just reading values | Enhanced for-loop |
| Need the index too | Classic `for (int i = 0; ...)` |
| Removing while iterating | `Iterator.remove()` |
| Replacing while iterating | `ListIterator.set()` |
| Need both key & value from a map | `entrySet()` |
| Short functional transform | `.forEach(...)` lambda |

---

## 8. Utility Classes

### 8.1 Arrays (utility recap)
See [Section 1.2](#12-core-arrays-class-methods) — `sort`, `fill`, `copyOf`, `equals`, `binarySearch`, `asList`, `toString`.

### 8.2 Collections

📦 `java.util.Collections` — static helper methods for `List`/`Set`/`Map` (the plural class, not to be confused with the `Collection` interface).

| Method | Purpose | Time Complexity |
|---|---|---|
| `Collections.sort(list)` | Sorts ascending (natural order) | O(n log n) |
| `Collections.sort(list, comparator)` | Custom order | O(n log n) |
| `Collections.reverse(list)` | Reverses in place | O(n) |
| `Collections.max(c)` / `Collections.min(c)` | Extremes of a collection | O(n) |
| `Collections.frequency(c, x)` | Count occurrences of `x` | O(n) |
| `Collections.reverseOrder()` | Comparator for descending natural order | O(1) to obtain |
| `Collections.unmodifiableList(list)` | Read-only view | O(1) |
| `Collections.emptyList()` | Immutable empty list | O(1) |
| `Collections.swap(list, i, j)` | Swaps two elements | O(1) |
| `Collections.shuffle(list)` | Randomly shuffles | O(n) |
| `Collections.binarySearch(list, key)` | Binary search on a **sorted** List | O(log n) |
| `Collections.nCopies(n, x)` | Immutable list of `n` copies of `x` | O(1) (lazy) |
| `Collections.addAll(coll, x1, x2, ...)` | Bulk-add varargs into a collection | O(k) |

⚠️ **Common Mistake:** Confusing `Collections` (the utility class, capital C, plural) with `Collection` (the root interface). `Collections.sort(...)` — note the "s".

### 8.3 Objects

📦 `java.util.Objects` — null-safe helper methods.

| Method | Purpose |
|---|---|
| `Objects.equals(a, b)` | Null-safe equality (`true` if both `null`) |
| `Objects.hashCode(x)` | Null-safe hash code (returns 0 for `null`) |
| `Objects.requireNonNull(x)` | Throws `NullPointerException` if `x` is `null` — great for input validation |
| `Objects.isNull(x)` / `Objects.nonNull(x)` | Readable null checks, handy in stream filters |
| `Objects.hash(a, b, c, ...)` | Combines multiple fields into one hash code (used when overriding `hashCode()`) |

### 8.4 Comparator

📦 `java.util.Comparator` — defines **external** ordering logic (doesn't require modifying the class).

```java
// Classic anonymous class
Comparator<int[]> byFirst = new Comparator<int[]>() {
    public int compare(int[] a, int[] b) { return a[0] - b[0]; }
};

// Lambda (Java 8+) — what you'll actually write in interviews
Comparator<int[]> byFirst2 = (a, b) -> a[0] - b[0];

// Comparator.comparing — most readable, best for objects
Comparator<Employee> byAge = Comparator.comparing(Employee::getAge);

// Multi-level sorting: sort by age, then by name
Comparator<Employee> multi = Comparator.comparing(Employee::getAge)
                                        .thenComparing(Employee::getName);

// Reversed
Comparator<Employee> desc = Comparator.comparing(Employee::getAge).reversed();
```
⚠️ **Common Mistake:** Writing `(a, b) -> a - b` for large `int` subtraction can **overflow** if values are near `Integer.MAX_VALUE`/`MIN_VALUE`. Prefer `Integer.compare(a, b)` for safety.

### 8.5 Comparable

📦 `java.lang.Comparable<T>` — defines **natural/internal** ordering by implementing it inside the class itself.

```java
class Employee implements Comparable<Employee> {
    int age;
    public int compareTo(Employee other) {
        return Integer.compare(this.age, other.age); // natural order = by age
    }
}
// Now Collections.sort(employees) and Arrays.sort(employees) work directly
```
🧠 **Memory Trick:** "Comparable = built into the class (one natural order). Comparator = external, and you can have many of them."

### 8.6 Optional (briefly)

📦 `java.util.Optional<T>` — a wrapper to avoid `NullPointerException`s, mostly seen when working with Streams.

```java
Optional<Integer> result = list.stream().max(Integer::compareTo);
int max = result.orElse(-1);          // fallback if empty
if (result.isPresent()) { ... }
result.ifPresent(v -> System.out.println(v));
```
💡 Rarely required to *write* your own `Optional` in DSA problems, but `stream().max()/.min()/.findFirst()` return one, so knowing `.orElse()` avoids crashes.

---

## 9. Sorting

### 9.1 Arrays.sort() vs Collections.sort()

| | `Arrays.sort()` | `Collections.sort()` |
|---|---|---|
| Works on | Arrays (primitive & object) | `List` implementations |
| Primitive support | ✅ Yes (`int[]`, `char[]`, etc.) | ❌ No — Lists only hold objects |
| Custom comparator | Only on object arrays | ✅ Always (via `List<T>`) |
| Underlying algorithm | Dual-pivot Quicksort (primitives) / TimSort (objects) | TimSort |
| Stable? | Objects: yes. Primitives: N/A (no duplicates issue since no identity) | Yes |

### 9.2 Custom Comparator & Lambda Comparator

```java
Integer[] arr = {5, 2, 9, 1};
Arrays.sort(arr, (a, b) -> b - a);          // descending, lambda

List<Integer> list = new ArrayList<>(List.of(5, 2, 9, 1));
Collections.sort(list, Collections.reverseOrder());
list.sort((a, b) -> a - b);                 // List has its own .sort() too (Java 8+)
```

### 9.3 Sorting Objects

```java
class Student { String name; int marks; }

List<Student> students = new ArrayList<>();
students.sort(Comparator.comparingInt(s -> s.marks));                 // ascending by marks
students.sort(Comparator.comparingInt((Student s) -> s.marks).reversed()); // descending
```

### 9.4 Sorting in Descending Order — All Techniques

```java
// 1. Primitive int[] — sort ascending, then reverse manually
Arrays.sort(arr);
// reverse loop...

// 2. Boxed Integer[] — use reverseOrder comparator
Arrays.sort(boxedArr, Collections.reverseOrder());

// 3. List<Integer>
list.sort(Collections.reverseOrder());

// 4. Custom objects
list.sort(Comparator.comparing(Obj::getField).reversed());
```

### 9.5 Multi-Level Sorting

```java
// Sort intervals by start ascending, then by end descending if starts are equal
Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

// Same thing, more readable with Comparator chaining (needs Integer[][] or List<int[]>... 
// for int[][] the lambda form above is the practical choice)
Comparator<Employee> cmp = Comparator.comparing(Employee::getDept)
                                      .thenComparing(Employee::getAge)
                                      .thenComparing(Employee::getName, Comparator.reverseOrder());
```
💡 **Common Interview Use:** Merge Intervals, Meeting Rooms, and any problem that says "sort by X, and if X is equal sort by Y."

---

## 10. Searching

### 10.1 Binary Search (manual template — expected in interviews)

```java
static int binarySearch(int[] arr, int target) {
    int lo = 0, hi = arr.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;   // avoids overflow vs (lo+hi)/2
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return -1; // not found
}
```
⚠️ **Common Mistake:** Writing `int mid = (lo + hi) / 2;` can overflow when `lo` and `hi` are both close to `Integer.MAX_VALUE`. Always write `lo + (hi - lo) / 2`.

### 10.2 Lower Bound Implementation

"Lower bound" = first index where `arr[i] >= target` (first position `target` could be inserted to keep sorted order).
```java
static int lowerBound(int[] arr, int target) {
    int lo = 0, hi = arr.length;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] < target) lo = mid + 1;
        else hi = mid;
    }
    return lo;
}
```

### 10.3 Upper Bound Implementation

"Upper bound" = first index where `arr[i] > target`.
```java
static int upperBound(int[] arr, int target) {
    int lo = 0, hi = arr.length;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] <= target) lo = mid + 1;
        else hi = mid;
    }
    return lo;
}
// Count of target in sorted array = upperBound(arr, target) - lowerBound(arr, target)
```
💡 **Common Interview Use:** "Find First and Last Position of Element in Sorted Array" (LeetCode 34) is exactly `lowerBound` + `upperBound - 1`.

### 10.4 Searching in Built-in Collections

| Structure | Search Method | Time Complexity |
|---|---|---|
| Sorted array | `Arrays.binarySearch(arr, key)` | O(log n) |
| Sorted `List` | `Collections.binarySearch(list, key)` | O(log n) |
| `HashMap` / `HashSet` | `containsKey(k)` / `contains(x)` | O(1) avg |
| `TreeMap` / `TreeSet` | `containsKey(k)` / `contains(x)` | O(log n) |
| Unsorted array/list | Linear scan (`indexOf`, `contains`) | O(n) |

🧠 **Memory Trick:** "Binary search needs sorted data. Hash needs nothing but O(1) memory tradeoff. Tree needs balance but keeps order."

---

## 11. HashMap Tricks

These are the methods you'll use in almost **every second DSA problem** involving counting, grouping, or caching.

**Function**
```java
map.getOrDefault(key, 0);
```
**Purpose:** Returns the value for `key`, or a default if the key doesn't exist — avoids a `containsKey` + `get` combo.
**Example**
```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : "aabbc".toCharArray())
    freq.put(c, freq.getOrDefault(c, 0) + 1);
// Output: {a=2, b=2, c=1}
```
**Time Complexity:** O(1) avg

**Function**
```java
map.merge(key, 1, Integer::sum);
```
**Purpose:** The cleanest one-liner for frequency counting — inserts `1` if absent, else adds `1` to the existing value.
**Example**
```java
Map<Character, Integer> freq = new HashMap<>();
for (char c : "aabbc".toCharArray())
    freq.merge(c, 1, Integer::sum);
// Output: {a=2, b=2, c=1}
```
🧠 **Memory Trick:** "merge = getOrDefault + put in one line." This is the fastest way to write a frequency counter in an interview.

**Function**
```java
map.putIfAbsent(key, new ArrayList<>());
```
**Purpose:** Ensures a key has a starting value (e.g., an empty list) only if it isn't already present — classic for building an adjacency list or grouping map.
**Example**
```java
Map<Integer, List<Integer>> graph = new HashMap<>();
graph.putIfAbsent(1, new ArrayList<>());
graph.get(1).add(2);
```

**Function**
```java
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
```
**Purpose:** Same intent as `putIfAbsent` but in one line — the standard idiom for building a graph/grouping map.
**Example**
```java
Map<Integer, List<Integer>> graph = new HashMap<>();
graph.computeIfAbsent(1, k -> new ArrayList<>()).add(2);
graph.computeIfAbsent(1, k -> new ArrayList<>()).add(3);
// graph = {1=[2, 3]}
```
🧠 **Memory Trick:** "computeIfAbsent = one-line adjacency list builder."

### 11.1 Quick Reference Table

| Method | Purpose |
|---|---|
| `get(k)` | Returns value, or `null` if key missing |
| `put(k, v)` | Insert or overwrite |
| `getOrDefault(k, def)` | Retrieve with fallback |
| `putIfAbsent(k, v)` | Insert only if key missing |
| `containsKey(k)` | Key existence check |
| `containsValue(v)` | Value existence check (O(n), avoid in hot loops) |
| `merge(k, v, fn)` | Combine with existing value or insert |
| `computeIfAbsent(k, fn)` | Compute & insert default only if key missing |
| `entrySet()` | Best way to loop key+value together |
| `keySet()` | Loop keys only |
| `values()` | Loop values only |

⚠️ **Common Mistake:** Calling `map.get(key).someMethod()` without checking for `null` first — throws `NullPointerException` if the key wasn't present. Use `getOrDefault` or check `containsKey` first.

---

## 12. Queue & Heap Tricks

### 12.1 Min Heap / Max Heap Quick Setup

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();                            // default
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());  // flipped
```

### 12.2 Custom Heap (objects / arrays)

```java
// Min-heap of [value, index] pairs, ordered by value
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

// Max-heap of Strings by length
PriorityQueue<String> pq2 = new PriorityQueue<>((a, b) -> b.length() - a.length());
```

### 12.3 Peek / Poll / Offer Semantics

| Method | Behavior | Time Complexity |
|---|---|---|
| `offer(x)` | Insert `x`, re-heapify | O(log n) |
| `poll()` | Remove & return root, re-heapify | O(log n) |
| `peek()` | View root without removing | O(1) |
| `size()` | Number of elements currently in heap | O(1) |

💡 **Common Interview Use — "K-way merge" pattern:**
```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // {value, listIndex, elemIndex}
// push the first element of each list, then repeatedly poll the smallest and push its successor
```
💡 **Common Interview Use — "Top K" pattern:** Keep a min-heap of size K; if `pq.size() > K`, `pq.poll()` the smallest so only the K largest remain.

⚠️ **Common Mistake:** Forgetting to bound the heap size in "Top K" problems — leads to O(n log n) instead of the intended O(n log k).

---

## 13. Bit Manipulation Helpers

📦 Bitwise operators are language-level (`&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`); `Integer`/`Long` classes add higher-level helpers.

### 13.1 Checking Odd / Even

```java
boolean isOdd = (n & 1) == 1;    // faster than n % 2 != 0, same result
```
🧠 **Memory Trick:** "Last bit = 1 → odd. Last bit = 0 → even."

### 13.2 Power of 2 Check

```java
boolean isPowerOfTwo = n > 0 && (n & (n - 1)) == 0;
```
🧠 **Memory Trick:** A power of two has exactly one set bit; `n & (n-1)` clears the lowest set bit — if that result is 0, there was only one bit to begin with.

### 13.3 Count Set Bits

```java
int count = Integer.bitCount(n);          // built-in, O(1)-ish, always prefer this

// Manual version (good to know the logic for interviews)
int manualCount = 0;
int x = n;
while (x != 0) { x &= (x - 1); manualCount++; }  // Brian Kernighan's algorithm
```
💡 **Interview Tip:** Interviewers sometimes explicitly ask you to implement bit counting "without using library functions" — Brian Kernighan's trick (`n & (n-1)`) is the expected answer.

### 13.4 Left / Right Shift

```java
int doubled = n << 1;     // multiply by 2
int halved = n >> 1;      // divide by 2 (floor, sign-preserving)
int unsigned = n >>> 1;   // divide by 2, treating n as unsigned (fills with 0, not sign bit)
```
⚠️ **Common Mistake:** Using `>>` on negative numbers when you actually want unsigned behavior — `>>` keeps the sign bit (arithmetic shift), `>>>` doesn't (logical shift). This matters for hashing/bitmask tricks with negative ints.

### 13.5 XOR Tricks

```java
int a = 5, b = 7;
a ^= b; b ^= a; a ^= b;  // swap without a temp variable

// Find the single non-duplicate number (all others appear twice)
int single = 0;
for (int x : arr) single ^= x;
```
🧠 **Memory Trick:** "XOR of a number with itself is 0; XOR with 0 is itself." That's why XOR-ing a whole array cancels every pair and leaves the lone number.

### 13.6 Bit Masking

```java
int setBit    = n | (1 << i);      // turn ON bit i
int clearBit  = n & ~(1 << i);     // turn OFF bit i
int toggleBit = n ^ (1 << i);      // flip bit i
boolean isSet = (n & (1 << i)) != 0; // check bit i

// Bitmask DP — represent subsets of a set of size k as integers 0..(1<<k)-1
for (int mask = 0; mask < (1 << k); mask++) {
    for (int i = 0; i < k; i++) {
        if ((mask & (1 << i)) != 0) { /* element i is in this subset */ }
    }
}
```
💡 **Common Interview Use:** Subset generation, Traveling Salesman DP, "Two Integers with same set bits", state-compression DP.

### 13.7 Useful Integer/Long Bit Methods

| Method | Purpose |
|---|---|
| `Integer.bitCount(n)` | Number of set bits |
| `Integer.numberOfLeadingZeros(n)` | Leading zero bits (32-bit) |
| `Integer.numberOfTrailingZeros(n)` | Trailing zero bits |
| `Integer.highestOneBit(n)` | Isolates the highest set bit |
| `Integer.lowestOneBit(n)` | Isolates the lowest set bit (`n & -n`) |
| `Integer.reverse(n)` | Reverses all 32 bits |
| `Long.bitCount(n)` | Same as above, for `long` |

---

## 14. Input & Output

### 14.1 Scanner vs BufferedReader vs StringTokenizer

| | `Scanner` | `BufferedReader` + `StringTokenizer` | `PrintWriter` |
|---|---|---|---|
| Package | `java.util.Scanner` | `java.io.BufferedReader`, `java.util.StringTokenizer` | `java.io.PrintWriter` |
| Speed | Slow (regex-based parsing) | Fast (raw buffered reads) | Fast buffered output |
| Ease of use | Very easy: `nextInt()`, `nextLine()` | Requires manual parsing/tokenizing | Easy: `println`, `printf` |
| Best for | Small inputs, quick scripts | Large inputs (10^5+ lines) — competitive programming | Any output, especially bulk output |

```java
// Scanner — simple but slow
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
String line = sc.nextLine();

// BufferedReader + StringTokenizer — fast, standard for competitive programming
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine().trim());
StringTokenizer st = new StringTokenizer(br.readLine());
int a = Integer.parseInt(st.nextToken());
int b = Integer.parseInt(st.nextToken());

// PrintWriter — fast, buffered output (flush at the end!)
PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
pw.println("Hello");
pw.flush();  // ⚠️ must flush, or output may not appear
```
⚠️ **Common Mistake:** Mixing `Scanner.nextInt()` then `Scanner.nextLine()` — `nextInt()` doesn't consume the trailing newline, so the next `nextLine()` reads an empty string. Call an extra `sc.nextLine()` to absorb it, or switch entirely to `BufferedReader`.

### 14.2 Fast I/O Template (competitive programming standard)

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();   // buffer output, print once at the end

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(n + k).append("\n");
        }

        System.out.print(sb);   // single I/O call at the end — much faster than printing in the loop
    }
}
```
🧠 **Memory Trick:** "Buffer in, buffer out." Read with `BufferedReader`, accumulate output in a `StringBuilder`, and print exactly once with `System.out.print(sb)`.
💡 **Interview Tip:** On Codeforces/AtCoder/CSES with tight time limits, `Scanner` alone can cause TLE (Time Limit Exceeded) on inputs with 10^5+ numbers — always switch to buffered I/O.

---

## 15. Frequently Used DSA Templates

These are the "muscle memory" templates you should be able to write blind. GCD, LCM, Fast Power, Prefix Sum, and Frequency Counter were already shown in [Section 4](#4-math-class) and [Section 6](#6-primitive-data-structures) — the rest are below.

### 15.1 GCD / LCM (recap)
```java
static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
static long lcm(int a, int b) { return (long) a / gcd(a, b) * b; }
```

### 15.2 Fast Power (recap)
```java
static long power(long a, long b, long mod) {
    long res = 1; a %= mod;
    while (b > 0) {
        if ((b & 1) == 1) res = (res * a) % mod;
        a = (a * a) % mod;
        b >>= 1;
    }
    return res;
}
```

### 15.3 Prime Check

```java
static boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; (long) i * i <= n; i++)
        if (n % i == 0) return false;
    return true;
}
```
**Time Complexity:** O(√n)
⚠️ **Common Mistake:** Looping `i` all the way to `n` instead of `√n` — turns an O(√n) check into O(n), which times out for large `n` (like 10^9).

### 15.4 Sieve of Eratosthenes

```java
static boolean[] sieve(int n) {
    boolean[] isComposite = new boolean[n + 1];
    isComposite[0] = isComposite[1] = true;
    for (int i = 2; (long) i * i <= n; i++) {
        if (!isComposite[i]) {
            for (int j = i * i; j <= n; j += i) {
                isComposite[j] = true;
            }
        }
    }
    return isComposite; // isComposite[x] == false  →  x is prime
}
```
**Time Complexity:** O(n log log n) &nbsp;&nbsp; **Space Complexity:** O(n)
💡 **Common Interview Use:** Precompute primality for all numbers up to 10^6–10^7 once, then answer prime-related queries in O(1) each — essential for CSES/Codeforces number theory problems.

### 15.5 Prefix Sum (recap)
```java
int[] prefix = new int[n + 1];
for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + arr[i];
```

### 15.6 Frequency Counter (recap)
```java
Map<Integer, Integer> freq = new HashMap<>();
for (int x : arr) freq.merge(x, 1, Integer::sum);
```

### 15.7 Binary Search (recap)
```java
static int binarySearch(int[] arr, int target) {
    int lo = 0, hi = arr.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) lo = mid + 1;
        else hi = mid - 1;
    }
    return -1;
}
```

### 15.8 BFS (Breadth-First Search)

```java
static void bfs(int start, List<List<Integer>> graph, int n) {
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        // process(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;   // mark on push, not on pop — avoids duplicate enqueues
                queue.offer(neighbor);
            }
        }
    }
}
```
**Time Complexity:** O(V + E)
⚠️ **Common Mistake:** Marking `visited` when you **poll** instead of when you **offer** — this lets the same node get added to the queue multiple times, wasting time and (in some graphs) causing wrong output.
💡 **Common Interview Use:** Shortest path in an unweighted graph, level-order traversal, "rotting oranges" style multi-source BFS.

### 15.9 DFS (Depth-First Search)

```java
// Recursive
static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    visited[node] = true;
    // process(node);
    for (int neighbor : graph.get(node)) {
        if (!visited[neighbor]) dfs(neighbor, graph, visited);
    }
}

// Iterative (using an explicit stack — avoids StackOverflowError on deep graphs)
static void dfsIterative(int start, List<List<Integer>> graph, int n) {
    boolean[] visited = new boolean[n];
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(start);
    while (!stack.isEmpty()) {
        int node = stack.pop();
        if (visited[node]) continue;
        visited[node] = true;
        // process(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) stack.push(neighbor);
        }
    }
}
```
**Time Complexity:** O(V + E)
⚠️ **Common Mistake:** Recursive DFS on a graph with 10^5+ nodes in a deep chain can throw `StackOverflowError` — switch to the iterative version for very large/deep graphs.

### 15.10 Union-Find (Disjoint Set Union)

```java
static int[] parent, rank_;

static void init(int n) {
    parent = new int[n];
    rank_ = new int[n];
    for (int i = 0; i < n; i++) parent[i] = i;
}

static int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]); // path compression
    return parent[x];
}

static void union(int a, int b) {
    int ra = find(a), rb = find(b);
    if (ra == rb) return;
    if (rank_[ra] < rank_[rb]) { int t = ra; ra = rb; rb = t; } // union by rank
    parent[rb] = ra;
    if (rank_[ra] == rank_[rb]) rank_[ra]++;
}
```
**Time Complexity:** Nearly O(1) amortized per operation (technically O(α(n)), the inverse Ackermann function)
💡 **Common Interview Use:** Number of Connected Components, Kruskal's MST, Redundant Connection, detecting cycles in an undirected graph.

### 15.11 Segment Tree (basic template — range sum, point update)

```java
static int[] tree;
static int n;

static void build(int[] arr, int node, int start, int end) {
    if (start == end) { tree[node] = arr[start]; return; }
    int mid = (start + end) / 2;
    build(arr, 2 * node, start, mid);
    build(arr, 2 * node + 1, mid + 1, end);
    tree[node] = tree[2 * node] + tree[2 * node + 1];
}

static void update(int node, int start, int end, int idx, int val) {
    if (start == end) { tree[node] = val; return; }
    int mid = (start + end) / 2;
    if (idx <= mid) update(2 * node, start, mid, idx, val);
    else update(2 * node + 1, mid + 1, end, idx, val);
    tree[node] = tree[2 * node] + tree[2 * node + 1];
}

static int query(int node, int start, int end, int l, int r) {
    if (r < start || end < l) return 0;                 // outside range
    if (l <= start && end <= r) return tree[node];       // fully inside range
    int mid = (start + end) / 2;
    return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
}

// Usage: tree = new int[4 * n]; build(arr, 1, 0, n - 1);
```
**Time Complexity:** Build O(n), Update O(log n), Query O(log n)
💡 **Common Interview Use:** Range Sum Query - Mutable (LeetCode 307), range minimum/maximum queries, competitive programming range-update problems.

---

## 16. Constructors — Consolidated Reference

Every constructor already appeared next to its data structure in earlier sections. This table is a single-page cross-reference for quick revision.

| Class | Constructor | When to Use |
|---|---|---|
| `ArrayList` | `new ArrayList<>()` | Default empty list |
| | `new ArrayList<>(int capacity)` | Known approximate size — avoids resizing |
| | `new ArrayList<>(Collection c)` | Build from existing array/collection |
| `LinkedList` | `new LinkedList<>()` | Empty list, or use as a `Deque` |
| | `new LinkedList<>(Collection c)` | Build from an existing collection |
| `ArrayDeque` | `new ArrayDeque<>()` | Preferred Stack/Queue/Deque implementation |
| | `new ArrayDeque<>(int capacity)` | Known approximate size |
| `PriorityQueue` | `new PriorityQueue<>()` | Min-heap, natural order |
| | `new PriorityQueue<>(Comparator c)` | Custom order (e.g., max-heap) |
| | `new PriorityQueue<>(int cap, Comparator c)` | Pre-sized + custom order |
| | `new PriorityQueue<>(Collection c)` | Heapify existing data in O(n) |
| `HashMap` | `new HashMap<>()` | Default capacity 16, load factor 0.75 |
| | `new HashMap<>(int capacity)` | Known key count — avoids rehashing |
| | `new HashMap<>(Map m)` | Copy another map |
| `HashSet` | `new HashSet<>()` | Default empty set |
| | `new HashSet<>(Collection c)` | Dedupe an existing collection |
| | `new HashSet<>(int capacity)` | Known element count |
| `TreeMap` | `new TreeMap<>()` | Natural (ascending) key order |
| | `new TreeMap<>(Comparator c)` | Custom key order |
| | `new TreeMap<>(Map m)` | Copy + sort an existing map |
| `TreeSet` | `new TreeSet<>()` | Natural order, sorted unique elements |
| | `new TreeSet<>(Comparator c)` | Custom order |
| | `new TreeSet<>(Collection c)` | Dedupe + sort existing data |
| `LinkedHashMap` | `new LinkedHashMap<>()` | Preserves insertion order |
| | `new LinkedHashMap<>(cap, loadFactor, true)` | Access-order mode — base for LRU cache |
| `LinkedHashSet` | `new LinkedHashSet<>()` | Unique elements, insertion order preserved |
| `StringBuilder` | `new StringBuilder()` | Default empty, capacity 16 |
| | `new StringBuilder(int capacity)` | Known approximate final length |
| | `new StringBuilder(String s)` | Start pre-filled with `s` |
| `Stack` | `new Stack<>()` | Legacy; prefer `ArrayDeque` instead |
| `Scanner` | `new Scanner(System.in)` | Simple, slower input reading |
| `BufferedReader` | `new BufferedReader(new InputStreamReader(System.in))` | Fast input reading |
| `PrintWriter` | `new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))` | Fast, buffered output |

---

## 17. Java DSA One-Liners

Powerful single-line snippets that save real time during contests.

```java
// Reverse an ArrayList
Collections.reverse(list);

// Reverse an array (in place, primitive)
for (int i = 0, j = arr.length - 1; i < j; i++, j--) { int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }

// Sort descending (boxed array / list)
Arrays.sort(boxedArr, Collections.reverseOrder());
list.sort(Collections.reverseOrder());

// Max / min of an array
int max = Arrays.stream(arr).max().getAsInt();
int min = Arrays.stream(arr).min().getAsInt();

// Sum of an array
int sum = Arrays.stream(arr).sum();
long longSum = Arrays.stream(arr).asLongStream().sum(); // safer for overflow-prone sums

// Frequency map in one line
Map<Integer, Long> freq = Arrays.stream(arr).boxed()
        .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

// int[] → List<Integer>
List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

// List<Integer> → int[]
int[] arr2 = list.stream().mapToInt(Integer::intValue).toArray();

// Deduplicate a list
List<Integer> unique = new ArrayList<>(new LinkedHashSet<>(list)); // preserves order
Set<Integer> uniqueSet = new HashSet<>(list);                      // order not preserved

// Convert String[] to List<String>
List<String> strList = Arrays.asList(strArr);          // fixed-size view
List<String> mutableList = new ArrayList<>(Arrays.asList(strArr)); // mutable copy

// Character frequency of a string in one line
int[] freqArr = new int[26];
s.chars().forEach(c -> freqArr[c - 'a']++);

// Check palindrome
boolean isPalin = s.equals(new StringBuilder(s).reverse().toString());

// Swap two array elements in one line
int t = arr[i]; arr[i] = arr[j]; arr[j] = t;

// Find max element's index
int maxIdx = IntStream.range(0, arr.length).reduce((i, j) -> arr[i] >= arr[j] ? i : j).getAsInt();

// Clone a 2D array (deep copy)
int[][] copy = Arrays.stream(original).map(int[]::clone).toArray(int[][]::new);

// Read n space-separated ints on one line into an array
int[] arr3 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

// Quick GCD via built-in BigInteger (rarely needed, but exists)
long g = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();

// Ternary-based min-of-three
int minOf3 = Math.min(a, Math.min(b, c));

// Join a List<Integer> into a comma string
String joined = list.stream().map(String::valueOf).collect(Collectors.joining(","));

// Count set bits, quick
int bits = Integer.bitCount(n);

// Sort a Map by value, descending, using streams
List<Map.Entry<String,Integer>> sorted = map.entrySet().stream()
        .sorted((a, b) -> b.getValue() - a.getValue())
        .collect(Collectors.toList());
```
💡 **Interview Tip:** Streams are elegant but slightly slower and harder to debug under contest time pressure — prefer plain loops when time limits are tight (Codeforces), and streams when clarity matters more (LeetCode, interviews).

---

## 18. Top 50 Interview Tricks

**Arrays & Strings**
1. Use `int[] freq = new int[26]` with `c - 'a'` indexing instead of a `HashMap<Character, Integer>` — it's faster and avoids boxing.
2. To check anagram equality, sort both strings' char arrays and compare, or compare two frequency arrays — both O(n).
3. `new StringBuilder(s).reverse().toString()` is the fastest one-line palindrome/reverse check.
4. For "two sum"-style problems, a `HashMap<value, index>` turns an O(n²) search into O(n).
5. Prefix sums + a `HashMap<prefixSum, count>` solve "subarray sum equals K" in O(n).
6. Sliding window (`left`/`right` pointers) turns many O(n²) substring/subarray problems into O(n).
7. `Arrays.asList(boxedArr)` gives you List operations on an array without copying data (careful: it's a fixed-size view).
8. Use `Character.isLetterOrDigit()` + `Character.toLowerCase()` together for "valid palindrome" style filtering.
9. `String.valueOf(charArray)` and `new String(charArray)` are equivalent — pick either, no performance difference.
10. Multiple return values from a single function: return an `int[]` or a custom small class instead of using global/static variables.

**Math & Bit Tricks**
11. `n & (n - 1)` clears the lowest set bit — the basis of power-of-2 checks and Brian Kernighan's bit-count algorithm.
12. `n & -n` isolates the lowest set bit — useful in Binary Indexed Tree (Fenwick Tree) implementations.
13. XOR-ing an entire array cancels all paired values, leaving the unique one — O(n) time, O(1) space.
14. `(a + b) / 2` can overflow; always write `a + (b - a) / 2` for computing a midpoint.
15. Use `Math.floorMod(a, m)` instead of `%` whenever negative numbers might appear in your modulo.
16. Cast to `long` **before** multiplying two `int`s that could exceed ~46,000 each (`(long) a * b`).
17. Fast exponentiation (`power(a, b, mod)`) turns O(b) repeated multiplication into O(log b).
18. To check if a number is a perfect square: `long r = (long) Math.sqrt(n); return r*r == n || (r+1)*(r+1) == n;` (accounts for floating-point rounding).
19. `Integer.MAX_VALUE` / `Integer.MIN_VALUE` are your go-to sentinels for "negative infinity"/"positive infinity" in DP and comparisons.
20. When counting digits: `(int) Math.log10(n) + 1` works but fails at edge cases (n=0) — a loop dividing by 10 is safer for edge cases.

**Collections & Data Structures**
21. `PriorityQueue` + bounding its size to `k` gives an O(n log k) solution to any "Top K" problem.
22. `Deque` as both a stack and queue means one import covers most "implement X using Y" problems.
23. `TreeMap.floorKey()`/`ceilingKey()` replace a lot of manual binary search logic for "closest value" problems.
24. `LinkedHashMap` with `removeEldestEntry()` overridden implements an LRU cache in ~10 lines.
25. `computeIfAbsent(key, k -> new ArrayList<>())` is the standard one-liner for building adjacency lists/graphs.
26. Use `Set.retainAll()` for set intersection and `removeAll()` for set difference instead of manual loops.
27. `Collections.unmodifiableList()` is a quick defensive-copy trick when returning internal lists from a method.
28. A monotonic `Deque` (increasing or decreasing) solves "sliding window maximum/minimum" in O(n).
29. Two heaps (a max-heap for the lower half, a min-heap for the upper half) solve "find median from data stream" in O(log n) per insert.
30. `Arrays.asList(1,2,3)` returns a **fixed-size** list — calling `.add()` on it throws `UnsupportedOperationException`.

**Sorting & Searching**
31. Sorting first often simplifies a problem enough that a greedy/two-pointer approach becomes obvious (interval problems, closest pair, etc.).
32. `lowerBound`/`upperBound` templates solve "count of X in sorted array" and "first/last occurrence" problems directly.
33. `Comparator.comparing(...).thenComparing(...)` chains handle multi-level sort criteria cleanly without messy lambdas.
34. For sorting `int[][]` by column descending: `(a, b) -> b[col] - a[col]` — no boxing needed since it's already an object array of `int[]`.
35. Binary search isn't just for arrays — it works on any monotonic function ("search on the answer" pattern for optimization problems).
36. `Arrays.sort()` on objects uses TimSort (stable) — equal elements keep their relative order, which matters for multi-pass sorting logic.

**Recursion, Graphs & DP**
37. Memoize recursive solutions with a `HashMap` (sparse states) or an array (dense/bounded states) — array lookups are faster when feasible.
38. Convert recursive DFS to iterative with an explicit `Deque` as a stack to avoid `StackOverflowError` on deep inputs.
39. Mark nodes visited **when you enqueue/push them**, not when you process them, to avoid duplicate work in BFS/DFS.
40. Union-Find with path compression + union by rank gives near-O(1) operations — always include both optimizations.
41. Dijkstra's algorithm = BFS + a `PriorityQueue` instead of a plain `Queue`, ordered by current shortest distance.
42. Topological sort (Kahn's algorithm) = BFS using in-degree counts and a queue of zero-in-degree nodes.
43. Bottom-up (tabulation) DP avoids recursion overhead and stack limits compared to top-down (memoized recursion) — prefer it for large state spaces.
44. Space-optimize DP by keeping only the previous row/state when the recurrence only depends on the last row (`dp[i]` depends only on `dp[i-1]`).

**General Java Idioms**
45. `Integer.compare(a, b)` is safer than `a - b` in comparators — avoids overflow for extreme values.
46. Autoboxing caches `Integer` values from -128 to 127 — `==` comparisons on Integers outside that range can silently fail; always use `.equals()` or `intValue()`.
47. `var` (Java 10+) can shorten verbose generic declarations (`var list = new ArrayList<Integer>();`) — useful for fast typing in contests.
48. Static nested helper methods (`gcd`, `power`, `isPrime`) should be declared once at the top of your class and reused across the file.
49. Precompute anything reusable (factorials mod p, sieve of primes, prefix sums) once outside your main query loop, not inside it.
50. Read the constraints first — `n ≤ 10^5` usually means O(n log n) is expected; `n ≤ 20` often hints at bitmask DP or brute force with pruning.

---

## 19. Top 50 Beginner Mistakes

**Arrays & Strings**
1. Comparing arrays with `==` or `.equals()` instead of `Arrays.equals()` — compares references, not contents.
2. Assuming `String` is mutable — every `+=` in a loop silently creates a brand-new `String` object, giving O(n²) behavior.
3. Forgetting `Arrays.sort(int[], Comparator)` doesn't compile — comparators only work on object arrays like `Integer[]`.
4. Using `list.remove(2)` when you meant to remove the **value** `2`, not the index — need `remove(Integer.valueOf(2))`.
5. Calling `s.split(",")` and expecting trailing empty strings to be kept — pass `-1` as the limit to keep them.
6. Modifying an array inside an enhanced for-loop and expecting the original array to change (works for objects' fields, not primitive reassignment).
7. Not trimming input before `Integer.parseInt()` — leading/trailing spaces throw `NumberFormatException`.
8. Assuming `char + char` gives a `char` — it actually promotes to `int`, so you must cast back: `(char)('a' + 1)`.
9. Forgetting `Arrays.fill()` doesn't work "deeply" on 2D arrays — you must loop over each row.
10. Using `new int[n]` and expecting garbage values (like in C) — Java always zero-initializes primitive arrays.

**Math**
11. Assuming `%` in Java always returns a non-negative result — it keeps the sign of the dividend for negative numbers.
12. Multiplying two `int`s and assigning to `long` without casting first — the overflow happens before the widening.
13. Forgetting `Math.abs(Integer.MIN_VALUE)` overflows back to `Integer.MIN_VALUE` (no positive counterpart exists in 32-bit two's complement).
14. Computing GCD/LCM without handling `0` as an input, causing division by zero.
15. Not taking `% MOD` after every intermediate step in modular arithmetic problems — only doing it once at the end causes overflow.

**Collections**
16. Trying `for (String k : map)` directly — `Map` isn't `Iterable`; you need `entrySet()`/`keySet()`/`values()`.
17. Calling `map.get(key)` and immediately chaining a method without a null check — throws `NullPointerException` if the key is missing.
18. Removing an element from a `List`/`Set` during a for-each loop directly — throws `ConcurrentModificationException`; use `Iterator.remove()` instead.
19. Expecting `HashMap`/`HashSet` to preserve insertion order — they don't; use `LinkedHashMap`/`LinkedHashSet` if order matters.
20. Iterating a `PriorityQueue` directly and expecting sorted output — only the root/peek is guaranteed to be min/max.
21. Forgetting `Stack` is a legacy, synchronized class — prefer `ArrayDeque` for better performance in contests.
22. Using `LinkedList` for heavy random access (`get(i)`) — it's O(n) per call, unlike `ArrayList`'s O(1).
23. Calling `Arrays.asList(arr)` and then trying to `.add()`/`.remove()` — throws `UnsupportedOperationException` since it's a fixed-size view.
24. Forgetting `subList()` returns a live view, not a copy — mutating the sublist mutates the original list too.
25. Declaring collections with raw types (`List list = new ArrayList();`) instead of generics — loses compile-time type safety.

**Sorting & Searching**
26. Writing `(a, b) -> a - b` in a comparator for large integers — subtraction can overflow; use `Integer.compare(a, b)`.
27. Running binary search on an unsorted array — the result is undefined/incorrect.
28. Writing `(lo + hi) / 2` for the midpoint — can overflow when both are large; use `lo + (hi - lo) / 2`.
29. Confusing `Arrays.binarySearch`'s return value when the key is absent — it's `-(insertionPoint) - 1`, not simply `-1`.
30. Forgetting `Collections.sort()` needs a `List`, not an array — arrays use `Arrays.sort()`.

**Bit Manipulation**
31. Using `>>` when you meant `>>>` (or vice versa) on negative numbers — arithmetic vs. logical shift give different results.
32. Forgetting operator precedence: `n & 1 == 1` parses as `n & (1 == 1)` and won't compile — always parenthesize: `(n & 1) == 1`.
33. Assuming bit tricks work identically on `int` vs `long` — shifting a 32-bit `int` past 31 bits wraps around; use `L` suffix and `long` for 64-bit-range problems.

**Recursion, Graphs & DP**
34. Writing recursive DFS without a visited check — causes infinite recursion on graphs with cycles.
35. Marking nodes visited when **popped/processed** instead of when **pushed/enqueued** — allows duplicate entries in the queue/stack.
36. Deep recursion on large inputs (10^5+ depth) — throws `StackOverflowError`; switch to an iterative approach.
37. Forgetting the base case in recursive DP — causes infinite recursion or wrong answers.
38. Re-computing the same subproblem repeatedly without memoization — turns an intended O(n) or O(n log n) solution into exponential time.
39. Initializing a DP array with `0` instead of `Integer.MAX_VALUE`/`MIN_VALUE` when the recurrence needs "infinity" as a starting sentinel.
40. Forgetting to reset `visited[]`/`dp[]` arrays between multiple test cases in a multi-test-case problem — leftover state causes wrong answers on later cases.

**I/O & General Java**
41. Using `Scanner` for large competitive programming inputs — too slow, causes Time Limit Exceeded on 10^5+ line inputs.
42. Mixing `nextInt()` and `nextLine()` on the same `Scanner` — `nextInt()` leaves a trailing newline that the next `nextLine()` picks up as empty input.
43. Printing inside a loop with `System.out.println()` for large outputs — each call flushes/writes separately and is slow; buffer with a `StringBuilder` and print once.
44. Forgetting to `flush()` a `PrintWriter` — buffered output may never actually appear.
45. Comparing boxed `Integer` objects with `==` — works "by accident" for -128 to 127 (integer cache) but fails outside that range; always use `.equals()`.
46. Not declaring helper methods `static` inside a `public static void main` context — causes a compile error when called from `main`.
47. Forgetting array/list indices are 0-based in Java — off-by-one errors are the most common bug in DSA code overall.
48. Ignoring input constraints and picking the wrong-complexity algorithm (e.g., O(n²) when n can be 10^6).
49. Not handling edge cases: empty array, single element, all-duplicate elements, negative numbers — these are the most common places solutions silently break.
50. Copy-pasting a solution to a slightly different sub-problem without re-checking the base cases/return type — many "close but wrong" submissions come from this.

---

## 20. When to Use What?

| Scenario | Choose | Why |
|---|---|---|
| Need random access by index, rarely insert/delete in the middle | `ArrayList` | O(1) `get`/`set`; O(n) insert/delete is rare in practice |
| Frequent insert/delete at both ends, rarely random access | `ArrayDeque` (or `LinkedList`) | O(1) at both ends; `ArrayDeque` has better cache locality and is usually faster |
| Need a Stack (LIFO) | `ArrayDeque` (`push`/`pop`/`peek`) | Faster than legacy `Stack`, which is synchronized |
| Need a Queue (FIFO) | `ArrayDeque` (`offer`/`poll`/`peek`) | Faster than `LinkedList` as a queue |
| Need both stack and queue behavior | `ArrayDeque` | Supports both ends natively |
| Need fast key lookup, order doesn't matter | `HashMap` / `HashSet` | O(1) average operations |
| Need keys sorted, or "closest value" queries (`floor`/`ceiling`) | `TreeMap` / `TreeSet` | O(log n) operations, maintains order |
| Need key lookup **and** insertion order preserved | `LinkedHashMap` / `LinkedHashSet` | O(1) like HashMap, plus predictable iteration order |
| Need an LRU cache | `LinkedHashMap` with access-order + `removeEldestEntry` | Purpose-built for this |
| Need repeated access to the current min/max of a changing set | `PriorityQueue` | O(log n) insert/remove, O(1) peek |
| Need to check "have I seen this before?" fast | `HashSet` | O(1) `contains` |
| Need element uniqueness **and** sorted order | `TreeSet` | Combines both properties |
| Need to count frequencies | `HashMap<Key, Integer>` (or `int[]` if key range is small, e.g. lowercase letters) | Array is faster when the key domain is small and known |
| Small, fixed key range (like 26 letters, digits 0–9) | Plain array (`int[26]`) | Faster than any Map — no hashing overhead |
| Need custom sort order on objects | `Comparator` (lambda or `Comparator.comparing`) | Doesn't require modifying the class |
| Need one single "natural" sort order baked into the class | `Comparable` (`compareTo`) | Works automatically with `Collections.sort`/`Arrays.sort` |
| Reading small/simple input | `Scanner` | Easiest syntax, fine for small inputs |
| Reading large competitive programming input (10^5+ lines) | `BufferedReader` + `StringTokenizer` | Much faster, avoids Time Limit Exceeded |
| Printing large output | `StringBuilder` buffered, printed once with `System.out.print` | Avoids slow repeated I/O calls |
| Graph traversal — shortest path, unweighted | BFS with `ArrayDeque` | Explores level by level |
| Graph traversal — connectivity, backtracking, topological order | DFS (recursive or iterative) | Naturally explores full paths |
| Graph traversal — shortest path, weighted (non-negative) | Dijkstra (BFS + `PriorityQueue`) | Greedy shortest-path expansion |
| Checking connectivity / cycles in an undirected graph | Union-Find (DSU) | Near O(1) per query with path compression |
| Repeated range-sum queries, no updates | Prefix Sum array | O(1) query after O(n) preprocessing |
| Repeated range-sum queries **with** point updates | Segment Tree (or Fenwick/BIT) | O(log n) both update and query |
| Repeated range **updates**, few point queries | Difference Array | O(1) update, O(n) to rebuild once at the end |
| Recursive solution risks deep call stacks | Iterative version with an explicit `Deque` | Avoids `StackOverflowError` |
| Need to solve a subset/state problem with small `n` (≤ ~20) | Bitmask DP | 2^n states fit in an `int`/`long` easily |
| Need "find the Kth largest/smallest" repeatedly | `PriorityQueue` bounded to size K | O(n log k), avoids full sort |

---

## 21. Top 100 Java DSA Functions — Quick Table

One-page reference. Sorted by category for fast scanning.

| # | Function | Class / Package | Purpose | Time Complexity |
|---|---|---|---|---|
| 1 | `sort(arr)` | `Arrays` (`java.util`) | Sort ascending | O(n log n) |
| 2 | `sort(arr, cmp)` | `Arrays` | Custom-order sort (object arrays only) | O(n log n) |
| 3 | `fill(arr, val)` | `Arrays` | Fill every index with a value | O(n) |
| 4 | `copyOf(arr, n)` | `Arrays` | Resized copy | O(n) |
| 5 | `copyOfRange(arr, a, b)` | `Arrays` | Copy sub-range | O(n) |
| 6 | `equals(a, b)` | `Arrays` | Compare array contents | O(n) |
| 7 | `deepEquals(a, b)` | `Arrays` | Compare nested/2D array contents | O(n·m) |
| 8 | `toString(arr)` | `Arrays` | Human-readable string | O(n) |
| 9 | `deepToString(arr)` | `Arrays` | Human-readable string for 2D arrays | O(n·m) |
| 10 | `binarySearch(arr, key)` | `Arrays` | Search sorted array | O(log n) |
| 11 | `asList(arr)` | `Arrays` | Array → fixed-size `List` view | O(1) |
| 12 | `stream(arr)` | `Arrays` | Array → `Stream`/`IntStream` | O(1) lazy |
| 13 | `length()` | `String` (`java.lang`) | Character count | O(1) |
| 14 | `charAt(i)` | `String` | Character at index | O(1) |
| 15 | `substring(a, b)` | `String` | Extract sub-string | O(n) |
| 16 | `indexOf(x)` | `String` | First index of `x` | O(n) |
| 17 | `lastIndexOf(x)` | `String` | Last index of `x` | O(n) |
| 18 | `contains(sub)` | `String` | Substring existence check | O(n) |
| 19 | `equals(other)` | `String` | Content equality | O(n) |
| 20 | `compareTo(other)` | `String` | Lexicographic comparison | O(n) |
| 21 | `toCharArray()` | `String` | Convert to `char[]` | O(n) |
| 22 | `split(regex)` | `String` | Split by delimiter | O(n) |
| 23 | `trim()` / `strip()` | `String` | Remove leading/trailing whitespace | O(n) |
| 24 | `replace(a, b)` | `String` | Replace all occurrences | O(n) |
| 25 | `toUpperCase()` / `toLowerCase()` | `String` | Case conversion | O(n) |
| 26 | `String.join(delim, ...)` | `String` (static) | Join strings with a delimiter | O(n) |
| 27 | `String.valueOf(x)` | `String` (static) | Convert any type to `String` | O(1)–O(n) |
| 28 | `matches(regex)` | `String` | Full regex match | O(n) |
| 29 | `append(x)` | `StringBuilder` | Add to end | Amortized O(1) |
| 30 | `insert(i, x)` | `StringBuilder` | Insert at index | O(n) |
| 31 | `deleteCharAt(i)` | `StringBuilder` | Remove a character | O(n) |
| 32 | `reverse()` | `StringBuilder` | Reverse in place | O(n) |
| 33 | `setCharAt(i, c)` | `StringBuilder` | Overwrite a character | O(1) |
| 34 | `toString()` | `StringBuilder` | Convert back to `String` | O(n) |
| 35 | `isDigit(c)` | `Character` (`java.lang`) | Digit check | O(1) |
| 36 | `isLetter(c)` | `Character` | Letter check | O(1) |
| 37 | `isLetterOrDigit(c)` | `Character` | Alphanumeric check | O(1) |
| 38 | `isUpperCase(c)` / `isLowerCase(c)` | `Character` | Case check | O(1) |
| 39 | `toUpperCase(c)` / `toLowerCase(c)` | `Character` | Convert case | O(1) |
| 40 | `getNumericValue(c)` | `Character` | Digit char → int | O(1) |
| 41 | `min(a, b)` / `max(a, b)` | `Math` (`java.lang`) | Smaller/larger value | O(1) |
| 42 | `abs(x)` | `Math` | Absolute value | O(1) |
| 43 | `pow(a, b)` | `Math` | Exponentiation (double) | O(1) |
| 44 | `sqrt(x)` | `Math` | Square root | O(1) |
| 45 | `ceil(x)` / `floor(x)` | `Math` | Round up/down | O(1) |
| 46 | `round(x)` | `Math` | Round to nearest | O(1) |
| 47 | `random()` | `Math` | Random double [0,1) | O(1) |
| 48 | `log(x)` / `log10(x)` | `Math` | Natural/base-10 log | O(1) |
| 49 | `floorDiv(a, b)` | `Math` | Floor-rounded division | O(1) |
| 50 | `floorMod(a, b)` | `Math` | Always-non-negative modulo | O(1) |
| 51 | `parseInt(s)` | `Integer` (`java.lang`) | `String` → `int` | O(n) |
| 52 | `valueOf(s)` | `Integer` | `String` → `Integer` (boxed) | O(n) |
| 53 | `toBinaryString(n)` | `Integer` | `int` → binary string | O(log n) |
| 54 | `toString(n)` | `Integer` | `int` → `String` | O(log n) |
| 55 | `compare(a, b)` | `Integer` | Overflow-safe comparison | O(1) |
| 56 | `bitCount(n)` | `Integer` | Count set bits | O(1) |
| 57 | `MAX_VALUE` / `MIN_VALUE` | `Integer` (constant) | Sentinel bounds | O(1) |
| 58 | `numberOfTrailingZeros(n)` | `Integer` | Count trailing zero bits | O(1) |
| 59 | `highestOneBit(n)` | `Integer` | Isolate highest set bit | O(1) |
| 60 | `parseLong(s)` | `Long` (`java.lang`) | `String` → `long` | O(n) |
| 61 | `add(x)` | `ArrayList` (`java.util`) | Append element | Amortized O(1) |
| 62 | `get(i)` | `ArrayList` | Random access | O(1) |
| 63 | `remove(i)` / `remove(Object)` | `ArrayList` | Remove by index/value | O(n) |
| 64 | `set(i, x)` | `ArrayList` | Overwrite index | O(1) |
| 65 | `sort(list)` | `Collections` (`java.util`) | Sort a `List` ascending | O(n log n) |
| 66 | `reverse(list)` | `Collections` | Reverse a `List` | O(n) |
| 67 | `max(c)` / `min(c)` | `Collections` | Extremes of a collection | O(n) |
| 68 | `frequency(c, x)` | `Collections` | Count occurrences | O(n) |
| 69 | `binarySearch(list, key)` | `Collections` | Search a sorted `List` | O(log n) |
| 70 | `reverseOrder()` | `Collections` | Descending-order `Comparator` | O(1) |
| 71 | `unmodifiableList(list)` | `Collections` | Read-only view | O(1) |
| 72 | `put(k, v)` | `HashMap` (`java.util`) | Insert/overwrite | O(1) avg |
| 73 | `get(k)` | `HashMap` | Retrieve value | O(1) avg |
| 74 | `getOrDefault(k, def)` | `HashMap` | Retrieve with fallback | O(1) avg |
| 75 | `containsKey(k)` | `HashMap` | Key existence check | O(1) avg |
| 76 | `putIfAbsent(k, v)` | `HashMap` | Insert only if absent | O(1) avg |
| 77 | `merge(k, v, fn)` | `HashMap` | Combine or insert | O(1) avg |
| 78 | `computeIfAbsent(k, fn)` | `HashMap` | Compute default if absent | O(1) avg |
| 79 | `entrySet()` / `keySet()` / `values()` | `HashMap` | Iterate key-value pairs / keys / values | O(1) view |
| 80 | `add(x)` / `contains(x)` / `remove(x)` | `HashSet` | Insert / check / delete | O(1) avg |
| 81 | `firstKey()` / `lastKey()` | `TreeMap` | Smallest/largest key | O(log n) |
| 82 | `floorKey(k)` / `ceilingKey(k)` | `TreeMap` | Closest key ≤ / ≥ | O(log n) |
| 83 | `first()` / `last()` | `TreeSet` | Smallest/largest element | O(log n) |
| 84 | `floor(x)` / `ceiling(x)` | `TreeSet` | Closest element ≤ / ≥ | O(log n) |
| 85 | `offer(x)` | `PriorityQueue` | Insert | O(log n) |
| 86 | `poll()` | `PriorityQueue` | Remove & return root | O(log n) |
| 87 | `peek()` | `PriorityQueue` | View root | O(1) |
| 88 | `push(x)` / `pop()` | `ArrayDeque` (as Stack) | Stack insert/remove | O(1) |
| 89 | `offerFirst(x)` / `offerLast(x)` | `ArrayDeque` | Insert at either end | O(1) |
| 90 | `pollFirst()` / `pollLast()` | `ArrayDeque` | Remove from either end | O(1) |
| 91 | `comparing(fn)` | `Comparator` (`java.util`) | Build a comparator from a key extractor | O(1) to build |
| 92 | `reversed()` | `Comparator` | Flip a comparator's order | O(1) |
| 93 | `thenComparing(fn)` | `Comparator` | Multi-level sort chaining | O(1) |
| 94 | `equals(a, b)` | `Objects` (`java.util`) | Null-safe equality | O(1)–O(n) |
| 95 | `requireNonNull(x)` | `Objects` | Null-check with exception | O(1) |
| 96 | `nextInt()` / `nextLine()` | `Scanner` (`java.util`) | Read input | O(1) per token (slow overall) |
| 97 | `readLine()` | `BufferedReader` (`java.io`) | Fast line read | O(n) |
| 98 | `nextToken()` | `StringTokenizer` (`java.util`) | Fast token parsing | O(1) per token |
| 99 | `println(x)` / `flush()` | `PrintWriter` (`java.io`) | Buffered output | O(1) / O(n) |
| 100 | `bitCount(n)` / `numberOfTrailingZeros(n)` | `Long` (`java.lang`) | 64-bit bit tricks | O(1) |

---

## 22. Ultimate Java DSA Quick Revision Sheet

*Read this page in under 15 minutes right before an interview or contest.*

**Time Complexity Cheat Sheet**

| Operation | ArrayList | LinkedList | HashMap/Set | TreeMap/Set | ArrayDeque | PriorityQueue |
|---|---|---|---|---|---|---|
| Access by index | O(1) | O(n) | — | — | — | — |
| Insert/remove at end | O(1)* | O(1) | — | — | O(1) | O(log n) |
| Insert/remove at front | O(n) | O(1) | — | — | O(1) | — |
| Search/contains | O(n) | O(n) | O(1) avg | O(log n) | O(n) | O(n) |
| Get min/max | O(n) | O(n) | — | O(log n) | — | O(1) peek |

*amortized

**Must-Know Syntax Recap**

```java
// Collections quick-declare
List<Integer> list = new ArrayList<>();
Map<Integer,Integer> map = new HashMap<>();
Set<Integer> set = new HashSet<>();
Deque<Integer> stack = new ArrayDeque<>();       // push/pop/peek
Deque<Integer> queue = new ArrayDeque<>();       // offer/poll/peek
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
TreeMap<Integer,Integer> tm = new TreeMap<>();
TreeSet<Integer> ts = new TreeSet<>();

// Sorting
Arrays.sort(arr);                                  // primitive ascending
Arrays.sort(boxedArr, Collections.reverseOrder());  // descending, boxed
list.sort((a, b) -> a - b);                         // list, ascending

// Frequency counting
map.merge(key, 1, Integer::sum);

// Binary search family
Arrays.binarySearch(arr, key);   // exact match, sorted array
// lowerBound / upperBound — see Section 10

// Fast power / GCD / modular ops — see Section 4 & 15
```

**The 10 Patterns That Solve 80% of DSA Problems**

1. **Two Pointers** — sorted array, pair/triplet sum, removing duplicates in place.
2. **Sliding Window** — subarray/substring with a size or sum condition.
3. **Prefix Sum / Difference Array** — range sum/update queries.
4. **HashMap for O(1) lookup** — two sum, grouping, frequency counting.
5. **Binary Search (on array or on the answer)** — sorted data, or "minimize the maximum" style problems.
6. **BFS/DFS** — graphs, grids, connectivity, shortest path (unweighted).
7. **Heap (PriorityQueue)** — Top K, merge K sorted lists, running median.
8. **DP (top-down memo or bottom-up table)** — optimal substructure + overlapping subproblems.
9. **Union-Find** — connectivity/grouping without full graph traversal.
10. **Backtracking (DFS + undo)** — permutations, combinations, subsets, N-Queens style problems.

**Before You Submit — 60-Second Checklist**
- [ ] Did I handle empty input / single element / all-duplicates?
- [ ] Could any sum/product overflow `int`? Cast to `long`.
- [ ] Is my array/list 0-indexed correctly everywhere?
- [ ] Did I reset any `static`/global state between test cases?
- [ ] Am I using `BufferedReader`/`StringBuilder` if the input/output is large?
- [ ] Does my comparator avoid `a - b` on values that could overflow?
- [ ] Did I mark visited nodes at the right time (on push, not on pop)?

---

## 23. Java DSA Contest Toolkit

Everything below can be pasted directly into a fresh `Main.java` for a contest or online assessment.

### 23.1 Frequently Used Imports

```java
import java.util.*;
import java.io.*;
import java.util.stream.*;
import static java.lang.Math.*;
```

### 23.2 Fast I/O Template

```java
import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            // ... read more tokens / lines as needed

            sb.append(n).append("\n");
        }

        System.out.print(sb);
    }
}
```

### 23.3 Frequently Used Constants

```java
static final int MOD = 1_000_000_007;
static final int INF = Integer.MAX_VALUE / 2;   // avoid true MAX_VALUE to prevent overflow on addition
static final long LINF = Long.MAX_VALUE / 2;
static final int[] DX = {0, 0, 1, -1};           // right, left, down, up (row/col grid moves)
static final int[] DY = {1, -1, 0, 0};
```

### 23.4 Common Helper Methods

```java
static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
static long lcm(int a, int b) { return (long) a / gcd(a, b) * b; }

static boolean isPrime(int n) {
    if (n < 2) return false;
    for (int i = 2; (long) i * i <= n; i++) if (n % i == 0) return false;
    return true;
}

static boolean[] sieve(int n) {
    boolean[] composite = new boolean[n + 1];
    composite[0] = composite[1] = true;
    for (int i = 2; (long) i * i <= n; i++)
        if (!composite[i])
            for (int j = i * i; j <= n; j += i) composite[j] = true;
    return composite;
}

static long power(long a, long b, long mod) {
    long res = 1; a %= mod;
    while (b > 0) {
        if ((b & 1) == 1) res = (res * a) % mod;
        a = (a * a) % mod;
        b >>= 1;
    }
    return res;
}

static long modInverse(long a, long mod) { return power(a, mod - 2, mod); } // mod must be prime

static void swap(int[] arr, int i, int j) { int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
```

### 23.5 Modular Arithmetic Helpers

```java
static long addMod(long a, long b, long mod) { return ((a % mod) + (b % mod)) % mod; }
static long subMod(long a, long b, long mod) { return (((a - b) % mod) + mod) % mod; }
static long mulMod(long a, long b, long mod) { return ((a % mod) * (b % mod)) % mod; }
```

### 23.6 Comparator Templates

```java
// Ascending by natural order
Comparator<Integer> asc = Comparator.naturalOrder();

// Descending
Comparator<Integer> desc = Comparator.reverseOrder();

// By a derived key (objects)
Comparator<int[]> byFirst = (a, b) -> a[0] - b[0];
Comparator<int[]> bySecondDesc = (a, b) -> b[1] - a[1];

// Multi-level (object version)
Comparator<Employee> multi = Comparator.comparing(Employee::getDept)
                                        .thenComparing(Employee::getAge)
                                        .thenComparing(Employee::getName);
```

### 23.7 PriorityQueue Templates

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
PriorityQueue<int[]> pqByFirst  = new PriorityQueue<>((a, b) -> a[0] - b[0]);   // e.g. Dijkstra {dist, node}
PriorityQueue<int[]> pqBySecond = new PriorityQueue<>((a, b) -> a[1] - b[1]);
```

### 23.8 Binary Search Template

```java
static int lowerBound(int[] arr, int target) {
    int lo = 0, hi = arr.length;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] < target) lo = mid + 1; else hi = mid;
    }
    return lo;
}

static int upperBound(int[] arr, int target) {
    int lo = 0, hi = arr.length;
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] <= target) lo = mid + 1; else hi = mid;
    }
    return lo;
}

// Binary search on the answer (monotonic predicate)
static int binarySearchOnAnswer(int lo, int hi, java.util.function.IntPredicate feasible) {
    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;
        if (feasible.test(mid)) hi = mid; else lo = mid + 1;
    }
    return lo;
}
```

### 23.9 Graph Template (Adjacency List)

```java
static List<List<Integer>> buildGraph(int n, int[][] edges, boolean directed) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int[] e : edges) {
        graph.get(e[0]).add(e[1]);
        if (!directed) graph.get(e[1]).add(e[0]);
    }
    return graph;
}

// Weighted version — adjacency list of {neighbor, weight}
static List<List<int[]>> buildWeightedGraph(int n, int[][] edges, boolean directed) {
    List<List<int[]>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    for (int[] e : edges) {
        graph.get(e[0]).add(new int[]{e[1], e[2]});
        if (!directed) graph.get(e[1]).add(new int[]{e[0], e[2]});
    }
    return graph;
}
```

### 23.10 BFS Template

```java
static int[] bfs(int start, List<List<Integer>> graph, int n) {
    int[] dist = new int[n];
    Arrays.fill(dist, -1);
    Queue<Integer> queue = new ArrayDeque<>();
    dist[start] = 0;
    queue.offer(start);
    while (!queue.isEmpty()) {
        int node = queue.poll();
        for (int nxt : graph.get(node)) {
            if (dist[nxt] == -1) {
                dist[nxt] = dist[node] + 1;
                queue.offer(nxt);
            }
        }
    }
    return dist; // dist[i] = shortest hop count from start, -1 if unreachable
}
```

### 23.11 DFS Template

```java
static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
    visited[node] = true;
    for (int nxt : graph.get(node)) {
        if (!visited[nxt]) dfs(nxt, graph, visited);
    }
}
```

### 23.12 Union-Find (DSU) Template

```java
static class DSU {
    int[] parent, rank_;
    DSU(int n) {
        parent = new int[n];
        rank_ = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (rank_[ra] < rank_[rb]) { int t = ra; ra = rb; rb = t; }
        parent[rb] = ra;
        if (rank_[ra] == rank_[rb]) rank_[ra]++;
        return true;
    }
}
```

### 23.13 Segment Tree Template (range sum, point update)

```java
static class SegTree {
    int[] tree;
    int n;
    SegTree(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 1, 0, n - 1);
    }
    void build(int[] arr, int node, int start, int end) {
        if (start == end) { tree[node] = arr[start]; return; }
        int mid = (start + end) / 2;
        build(arr, 2 * node, start, mid);
        build(arr, 2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
    void update(int idx, int val) { update(1, 0, n - 1, idx, val); }
    void update(int node, int start, int end, int idx, int val) {
        if (start == end) { tree[node] = val; return; }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node, start, mid, idx, val);
        else update(2 * node + 1, mid + 1, end, idx, val);
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
    int query(int l, int r) { return query(1, 0, n - 1, l, r); }
    int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return query(2 * node, start, mid, l, r) + query(2 * node + 1, mid + 1, end, l, r);
    }
}
```

### 23.14 Prime Utilities (recap)

```java
static boolean isPrime(int n) { /* see 23.4 */ }
static boolean[] sieve(int n) { /* see 23.4 */ }
```

### 23.15 Other Reusable Snippets

```java
// Read all remaining tokens from a BufferedReader stream in one go (StreamTokenizer — even faster than StringTokenizer)
static StreamTokenizer in = new StreamTokenizer(new BufferedInputStream(System.in));
static int nextInt() throws IOException { in.nextToken(); return (int) in.nval; }

// Debug printing (remove before final submission!)
static void debug(Object... vals) { System.err.println(Arrays.deepToString(vals)); }

// 2D array deep clone
static int[][] deepClone(int[][] arr) {
    return Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
}

// Convert adjacency matrix to adjacency list
static List<List<Integer>> matrixToList(int[][] adjMatrix) {
    int n = adjMatrix.length;
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
        for (int j = 0; j < n; j++)
            if (adjMatrix[i][j] == 1) graph.get(i).add(j);
    }
    return graph;
}
```

---

## Final Notes

- Revisit **Section 22 (Ultimate Quick Revision Sheet)** and **Section 23 (Contest Toolkit)** the morning of an interview or contest — together they cover roughly 90% of what you'll actually type under time pressure.
- Keep **Section 21 (Top 100 Functions Table)** open in a second tab during timed practice until the methods become muscle memory.
- Revisit **Section 19 (Beginner Mistakes)** after every failed submission — most bugs in early DSA practice are on that list.

*Good luck — you now have less reason to leave this sheet and open Stack Overflow mid-interview.*
