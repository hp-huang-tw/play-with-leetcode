func twoSum(nums []int, target int) []int {
    hash := make(map[int]int)
    
    for i, num := range nums {
        complement := target - num
        
        if _, ok := hash[complement]; ok {
            return []int{hash[complement], i}
        }
        
        hash[num] = i
    }
    
    return []int{-1, -1}
}