public class Solution{
public int[] dailyTemperatures(int[] temperatures) {

    // Store INDEX, not temperature
    Stack<Integer> helperStack = new Stack<>();

    int n = temperatures.length;

    // Initially all values are 0
    int[] result = new int[n];

    // Process from right to left
    for(int idx = n - 1; idx >= 0; idx--) {

        // Remove useless candidates
        while(!helperStack.isEmpty()
              && temperatures[idx] >= temperatures[helperStack.peek()]) {

            helperStack.pop();
        }

        // Stack is not empty:
        // top is the next warmer day's index
        if(!helperStack.isEmpty()) {

            result[idx] = helperStack.peek() - idx;
        }

        // Current index becomes a candidate
        // for days on its left
        helperStack.push(idx);
    }

    return result;
}
}