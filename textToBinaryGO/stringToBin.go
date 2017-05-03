package main

import (
    "fmt"
    "io/ioutil"
    "os"
)

func binary(s string) string {
    res := ""
    for _, c := range s {
        res = fmt.Sprintf("%s%.8b", res, c)
    }
    return res
}

func main() {
    b, err := ioutil.ReadFile("string.txt") 
    if err != nil {
        fmt.Print(err)
    }

    str := string(b) 

    fmt.Println(str)

    str2 := binary(str) 

    fmt.Println(str2) 

    file, err := os.Create("string.bin") 
    if err != nil {
        return
    }
    defer file.Close()

    file.WriteString(str2) 
}
