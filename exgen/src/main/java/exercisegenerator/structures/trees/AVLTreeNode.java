package exercisegenerator.structures.trees;

import java.util.*;

public class AVLTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {

    final int height;

    AVLTreeNode(final T value, final AVLTreeNodeFactory<T> nodeFactory) {
        super(value, nodeFactory);
        this.height = 1;
    }

    AVLTreeNode(
        final T value,
        final Optional<? extends BinaryTreeNode<T>> leftChild,
        final Optional<? extends BinaryTreeNode<T>> rightChild,
        final AVLTreeNodeFactory<T> nodeFactory
    ) {
        super(value, leftChild, rightChild, nodeFactory);
        this.height = Math.max(BinaryTreeNode.height(leftChild), BinaryTreeNode.height(rightChild)) + 1;
    }

    @Override
    public BinaryTreeNodeSteps<T> balanceWithSteps() {
        final int diff = this.leftHeight() - this.rightHeight();
        if (diff < -1) {
            return this.balanceRightToLeft();
        } else if (diff > 1) {
            return this.balanceLeftToRight();
        } else {
            return new BinaryTreeNodeSteps<T>();
        }
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    int leftHeight() {
        return BinaryTreeNode.height(this.leftChild);
    }

    int rightHeight() {
        return BinaryTreeNode.height(this.rightChild);
    }

    private BinaryTreeNodeSteps<T> balanceLeftToRight() {
        @SuppressWarnings("unchecked")
        final
        AVLTreeNode<T> left = (AVLTreeNode<T>)this.leftChild.get();
        if (
            left.rightChild.isEmpty() ||
            (left.leftChild.isPresent() && left.rightChild.get().getHeight() <= left.leftChild.get().getHeight())
        ) {
            return this.rotateRight();
        }
        final BinaryTreeNodeSteps<T> result = this.asLeftChildren(left.rotateLeft());
        result.addAll(((AVLTreeNode<T>)result.getLast().x.get()).rotateRight());
        return result;
    }

    private BinaryTreeNodeSteps<T> balanceRightToLeft() {
        @SuppressWarnings("unchecked")
        final AVLTreeNode<T> right = (AVLTreeNode<T>)this.rightChild.get();
        if (
            right.leftChild.isEmpty() ||
            (right.rightChild.isPresent() && right.leftChild.get().getHeight() <= right.rightChild.get().getHeight())
        ) {
            return this.rotateLeft();
        }
        final BinaryTreeNodeSteps<T> result = this.asRightChildren(right.rotateRight());
        result.addAll(((AVLTreeNode<T>)result.getLast().x.get()).rotateLeft());
        return result;
    }

    private BinaryTreeNodeSteps<T> rotateLeft() {
        return new BinaryTreeNodeSteps<T>(
            this.rightChild.get().setLeftChild(this.setRightChild(this.rightChild.get().leftChild)),
            new BinaryTreeStep<T>(BinaryTreeStepType.ROTATE_LEFT, this.value)
        );
    }

    private BinaryTreeNodeSteps<T> rotateRight() {
        return new BinaryTreeNodeSteps<T>(
            this.leftChild.get().setRightChild(this.setLeftChild(this.leftChild.get().rightChild)),
            new BinaryTreeStep<T>(BinaryTreeStepType.ROTATE_RIGHT, this.value)
        );
    }

}
