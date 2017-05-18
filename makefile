JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class: 
	$(JC) $(JFLAGS) $*.java
CLASSES =\
	decoder.java \
	FourWayHeapNode.java \
	Huffman_Binary_Heap.java \
	Time_Calculation.java \
	PairHeap.java \
	BinaryNode.java \
	Decode_Tree.java \
	Huffman_FourWayHeap.java \
	PairHeapNode.java \
	FourWayHeap.java \
	Frequency.java \
	Huffman_PairHeap.java \
        encoder.java \
	Node.java
MAIN = Encoder
default: classes
classes: $(CLASSES:.java=.class)
clean:
	find . -type f | xargs -n 5 touch
	$(RM) *.class
