func search(nums []int, target int) int {
    l := 0
	r := len(nums) - 1

	for l <= r {
        mid := (l + r)/2
		num := nums[mid]
		if target == num {
			return mid
		}

		if target > num {
			l = mid + 1
		} else {
			r = mid - 1
		}
	}
	return -1
}
