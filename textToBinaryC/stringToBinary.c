#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* stringToBinary(char* s) {
    
    if(s == NULL) return 0; 
    size_t len = strlen(s);
    char *binary = malloc(len*8 + 1); 
    binary[0] = '\0';
    for(size_t i = 0; i < len; ++i) {
        char ch = s[i];
        for(int j = 7; j >= 0; --j){
            if(ch & (1 << j)) {
                strcat(binary,"1");
            } else {
                strcat(binary,"0");
            }
        }
    }
    return binary;
}

char *inputString(FILE* fr, size_t size){
    char *str;
    int ch;
    size_t len = 0;
    str = realloc(NULL, sizeof(char)*size);
    if(!str)return str;
    while(EOF!=(ch=fgetc(fr)) && ch != '\n'){
        str[len++]=ch;
        if(len==size){
            str = realloc(str, sizeof(char)*(size+=16));
            if(!str)return str;
        }
    }
    str[len++]='\0';

    return realloc(str, sizeof(char)*len);
}

int main(void){
    FILE *fr = fopen("string.txt", "r");
    FILE *fw = fopen("string.bin", "wb");
    char *c;

    c = inputString(fr, 10);
    char *b = stringToBinary(c);
    fwrite(b,strlen(b),1,fw);
    printf("Strings in string.txt succesfully converted into string.bin.\n");

    free(c);
    fclose(fr);
    fclose(fw);
    return 0;
}
