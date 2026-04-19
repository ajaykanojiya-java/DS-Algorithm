package practiceset.recursion;

/**
 * Solves the 0/1 Knapsack problem using practiceset.recursion.
 *
 * Problem: Given items with (weight, price) and a bag capacity, pick a subset of items
 * so total weight does not exceed capacity and total price is maximum.
 * Each item can be chosen at most once.
 *
 * Example from main:
 * items = [(Mac,2,3), (iPhone,3,4), (Jwellary,4,5), (Watches,5,6)], capacity = 5
 * Best choice is Mac + iPhone -> total weight = 5, total price = 7.
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        Item[] items = {new Item("Mac", 2, 3), new Item("iPhone", 3, 4), new Item("Jwellary", 4, 5), new Item("Watches", 5, 6)};
        int capacity = 5;
        System.out.println(knapsack(items, capacity));
    }

    static int knapsack(Item[] items, int capacity) {
        // Start recursive exploration from index 0 with empty bag state.
        int maxPrice = helper(items, 0, capacity, 0, 0,0);
        return maxPrice;
    }

    static int helper(Item[] items, int index, int capacity, int runningWeight, int runningPrice, int maxPrice) {

        // Prune this path if it exceeds allowed capacity.
        if (runningWeight > capacity) {
            return maxPrice;
        }

        // If bag is exactly full, capture the best value for this path.
        if (runningWeight == capacity) {
            maxPrice = Math.max(maxPrice, runningPrice);
            return maxPrice;
        }

        // No more items left; finalize this path's contribution.
        if (index == items.length) {
            maxPrice = Math.max(maxPrice, runningPrice);
            return maxPrice;
        }

        // Choice 1: include current item and move to next index.
        int price = items[index].getPrice();
        int weight = items[index].getWeight();
        maxPrice = helper(items, index + 1, capacity, runningWeight + weight, runningPrice + price, maxPrice);


        // Choice 2: explore path without keeping the current inclusion.
        maxPrice = helper(items, index + 1, capacity, runningWeight - weight, runningPrice - price, maxPrice);
        return maxPrice;
    }
}

