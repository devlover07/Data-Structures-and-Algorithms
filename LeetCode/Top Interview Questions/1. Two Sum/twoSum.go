package main

import "fmt"

func twoSum(nums []int, target int) []int {
    numIndexMap := make(map[int]int)
    for i, num := range nums {
        complement := target - num
        if index, exists := numIndexMap[complement]; exists {
            return []int{index, i}
        }
        numIndexMap[num] = i
    }
    return []int{}
}