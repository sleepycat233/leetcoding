import sys
import io

def getFileName(title):
    # title = "Construct Binary Tree from Preorder and Inorder Traversal"
    # res = ""
    res = io.StringIO()
    for s in title:
        if not s.isupper():
            # res += s.capitalize()
            res.write(s.capitalize())
        else:
            # res += s
            res.write(s)

    res.write(".java")
    print(res.getvalue())
    res.close()


getFileName(sys.argv[1:])
