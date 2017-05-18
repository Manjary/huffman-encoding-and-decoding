"# huffman-encoding-and-decoding" 
Huffman encoder and decoder:
For encoder , built huffman tree with three priority queues :
     1.binary heap
     2.4way cache optimised heap
     3.pairing heap
After performance analysis of above mentioned priority queues, 4way cache optimzed heap stood best and I have used it to build encoder.

For decoder:
Decoding is implemented by tracing the decoder tree, which is built on modified binary search tree.
