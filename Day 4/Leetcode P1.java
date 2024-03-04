// Leetcode 948. Bag of Tokens

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int n = tokens.length;
        Arrays.sort(tokens);

        int maxScore = 0, currScore = 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left++];
                currScore++;
                maxScore = Math.max(maxScore, currScore);
            } else if (currScore > 0) {
                P += tokens[right--];
                currScore--;
            } else {
                break;
            }
        }

        return maxScore;
    }
}

// The code is a solution to the Bag of Tokens problem on LeetCode.
// The problem statement is as follows: You have an initial power P, an initial
// score of 0 points, and a bag of tokens.
// Each token can be used at most once, has a value token[i], and has
// potentially two ways to use it.
// If we have at least token[i] power, we may play the token face up, losing
// token[i] power, and gaining 1 point.
// If we have at least 1 point, we may play the token face down, gaining
// token[i] power, and losing 1 point.
// Return the largest number of points you can win with the given tokens.
// The first line in this code declares that this function will return an
// integer value.
// It takes in two parameters: "tokens" which is an array of integers
// representing different values for each type of tokens; "P" which represents
// our current amount of energy or 'power'.
// Next comes some basic initialization where n = length(tokens) so that later
// on when looping through all elements in 'tokens' array (line #5), I don't
// need to keep calling .length() method over & over again - instead I just call
// n times (which saves time).
// Then comes Arrays.sort(tokens) - This sorts my input array from smallest
// element to biggest element.
// This helps me because then I know what are my cheapest options available if I
// want to buy more tokens using my existing energy/power.
// Now let's look into main logic behind solving this problem: I'm going through
// all elements starting from leftmost index i.e., index=0 till rightmost index
// i.e., index=n-1 Inside while loop there are three conditions: Condition#01:
// If currentPower >= costOfCheapestTokenAvailableInBag This means if currently
// whatever amount/energy/power I've got stored inside variable called 'P
// The code attempts to find the maximum score that can be obtained by using
// tokens from a bag, where each token has a certain value and can be used to
// increase the current score, but also requires a certain amount of power (P)
// to use.
// The code sorts the tokens in ascending order and then uses a two-pointer
// approach to determine the maximum score that can be obtained by using the
// given amount of power.