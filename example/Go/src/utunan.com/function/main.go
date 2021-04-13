package main

import (
	"fmt"
)

func main()  {
	happy("你好")
}


func happy(s string) (int,int) {
	fmt.Print(s)
	return 0 ,1
}

func crazy(s string) int {
	fmt.Print(s)
	return 0
}