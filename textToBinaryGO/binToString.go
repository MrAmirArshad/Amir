package main

import (
    "fmt"
    "io/ioutil"
    "os"
    "strconv"
)

func binary(c []byte) string {
    n := -1
    for i, b := range c {
        if b == 0 {
            break
        }
        n = i
    }
    return string(c[:n+1])
}

  func binToStr(binStr string) int {

          result, _ := strconv.ParseInt(binStr, 2, 64)
          return int(result)
  }


func main() {
    b, err := ioutil.ReadFile("string.bin") 
    if err != nil {
        fmt.Print(err)
    }

    fmt.Println(b) 

    str := string(b) 

    fmt.Println(str) 

    fmt.Printf("%b\n", str)

    file, err := os.Create("cba.txt")
    if err != nil {
        return
    }
    defer file.Close()
}
