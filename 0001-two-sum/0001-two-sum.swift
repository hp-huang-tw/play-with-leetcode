class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var numsMap: [Int: Int] = [:]
        
        for (i, num) in nums.enumerated() {
            var complement = target - num
            
            if let foundComplement = numsMap[complement] {
                return [foundComplement, i]
            }
            numsMap[num] = i
        }
        
        return []
    }
}