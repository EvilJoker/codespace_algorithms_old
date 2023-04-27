在Linux系统中拆分和合并文件，可以使用split和cat两个命令组合使用


split -b 49M bigfile.txt splitfile

cat splitfile* > bigfile.txt