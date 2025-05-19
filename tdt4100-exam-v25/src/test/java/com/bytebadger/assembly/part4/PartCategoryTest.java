package com.bytebadger.assembly.part4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PartCategoryTest {

    @Test
    public void testChildIsDescendantOfParent() {
        PartCategory parent = new PartCategory("Parent");
        PartCategory child = new PartCategory("Child");
        parent.addChildCategory(child);
        assertTrue(child.isDescendantOf(parent));
    }

    @Test
    public void testCategoryIsNotDescendantOfUnrelatedCategory() {
        PartCategory category1 = new PartCategory("Category1");
        PartCategory category2 = new PartCategory("Category2");
        assertFalse(category1.isDescendantOf(category2));
    }

    @Test
    public void testCategoryIsNotDescendantOfItself() {
        PartCategory category = new PartCategory("Category");
        assertFalse(category.isDescendantOf(category));
    }

    @Test
    public void testCategoryWithNoParentIsNotDescendantOfAnyCategory() {
        PartCategory category = new PartCategory("Category");
        PartCategory unrelatedCategory = new PartCategory("UnrelatedCategory");
        assertFalse(category.isDescendantOf(unrelatedCategory));
    }

    @Test
    public void testMultipleLevelsOfDescendants() {
        PartCategory grandparent = new PartCategory("Grandparent");
        PartCategory parent = new PartCategory("Parent");
        PartCategory child = new PartCategory("Child");
        grandparent.addChildCategory(parent);
        parent.addChildCategory(child);
        assertAll(
            () -> assertTrue(parent.isDescendantOf(grandparent)),
            () -> assertTrue(child.isDescendantOf(parent)),
            () -> assertTrue(child.isDescendantOf(grandparent))
        );
    }
}