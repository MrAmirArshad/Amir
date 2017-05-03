#include <stdio.h>
#include <string.h>
#include <stdlib.h>

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

int copyBinToText(char* rafname, char* txtname)      
{
    FILE *fraf, *ftxt;
char *c;    
c = inputString(fraf, 10);
    if ((fraf = fopen(rafname,"rb")) == NULL)
        return 0;                                   

    if ((ftxt = fopen(txtname,"wt")) == NULL) {     
        fclose(fraf);
        return 0;                                  
    }
    fprintf(ftxt, "---------------------------------------\n");
    while(fread(&fraf, strlen(c), 1, ftxt) == 1)       
        fprintf(ftxt, "%s\n",NULL);
    fclose(ftxt);

    fclose(fraf);
    return 1;                                       
}

int makefile(char* rafname)
{
    FILE *fraf, *ftxt;
    
    if ((fraf = fopen(rafname,"wb")) == NULL)
        return 0;                                  

    fclose(fraf);
    return 1;                                     
}

int main(void)
{
    if (makefile("string.bin") == 0)
        printf("Failure\n");
    else {
        if (CopyBin2Text("string.bin", "reversed.txt") == 0)
            printf("Failure\n");
        else
            printf("Success\n");
    }
    return 0;
}
