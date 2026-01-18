import java.util.*;

class Solution {
    public String countOfAtoms(String formula) {

        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>()); // base map

        int n = formula.length();
        int i = 0;

        while (i < n) {
            char ch = formula.charAt(i);

            if (ch == '(') {
                // new scope
                stack.push(new HashMap<>());
                i++;
            }
            else if (ch == ')') {
                i++;

                // read multiplier after ')'
                int mult = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    mult = mult * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (mult == 0) mult = 1;

                // pop current map
                Map<String, Integer> curr = stack.pop();
                Map<String, Integer> prev = stack.peek();

                // merge into previous map
                for (String atom : curr.keySet()) {
                    int val = curr.get(atom) * mult;
                    prev.put(atom, prev.getOrDefault(atom, 0) + val);
                }
            }
            else {
                // parse atom name
                StringBuilder atom = new StringBuilder();
                atom.append(ch);
                i++;

                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    atom.append(formula.charAt(i));
                    i++;
                }

                // parse count
                int count = 0;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + (formula.charAt(i) - '0');
                    i++;
                }
                if (count == 0) count = 1;

                // add to current map
                Map<String, Integer> top = stack.peek();
                top.put(atom.toString(), top.getOrDefault(atom.toString(), 0) + count);
            }
        }

        // final map
        Map<String, Integer> result = stack.pop();

        // sort atoms lexicographically
        TreeMap<String, Integer> sorted = new TreeMap<>(result);

        StringBuilder ans = new StringBuilder();
        for (String atom : sorted.keySet()) {
            ans.append(atom);
            if (sorted.get(atom) > 1)
                ans.append(sorted.get(atom));
        }

        return ans.toString();
    }
}
