import sys
import io

def getFileName(title):
    res = io.StringIO()
    for s in title:
        if not s.isupper():
            res.write(s.capitalize())
        else:
            res.write(s)

    res.write(".java")
    print(res.getvalue())
    res.close()


getFileName(sys.argv[1:])
