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
    b, err := ioutil.ReadFile("abc.txt") // just pass the file name
    if err != nil {
        fmt.Print(err)
    }

    //fmt.Println(b) // print the content as 'bytes'

    str := string(b) // convert content to a 'string'

    fmt.Println(str) // print the content as a 'string'

    str2 := binary(str) // convert the string into binary number,char by char.

    fmt.Println(str2) // print the content as a 'string'

    file, err := os.Create("abc.bin") // create a bin file
    if err != nil {
        return
    }
    defer file.Close()

    file.WriteString(str2) // write the string binary into bin file.
}
