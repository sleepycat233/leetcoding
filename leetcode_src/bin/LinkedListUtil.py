from typing import *
import re

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def print(self):
        while self:
            # print(self.val, sep='', end='->')
            print(f'[{self.val}]->', end='')
            self = self.next
        print()

def generateLinkedList(s: str) -> Optional[ListNode]:
    list = re.split('\\D+', s)
    # print(list)

    nn = None
    for x in reversed(list):
        pn = ListNode(int(x), nn)
        nn = pn

    return nn
