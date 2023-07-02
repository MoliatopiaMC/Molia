package gg.airplane.structs;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang.Validate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class ItemListWithBitset extends AbstractList<ItemStack> {
    public static ItemListWithBitset fromList(List<ItemStack> list) {
        if (list instanceof ItemListWithBitset ours) {
            return ours;
        }
        return new ItemListWithBitset(list);
    }

    private static ItemStack[] createArray(int size) {
        ItemStack[] array = new ItemStack[size];
        Arrays.fill(array, ItemStack.EMPTY);
        return array;
    }

    private final ItemStack[] items;

    private long bitSet = 0;
    private final long allBits;

    private static class OurNonNullList extends NonNullList<ItemStack> {
        protected OurNonNullList(List<ItemStack> delegate) {
            super(delegate, ItemStack.EMPTY);
        }
    }

    public final NonNullList<ItemStack> nonNullList = new OurNonNullList(this);

    private ItemListWithBitset(List<ItemStack> list) {
        this(list.size());

        for (int i = 0; i < list.size(); i++) {
            this.set(i, list.get(i));
        }
    }

    public ItemListWithBitset(int size) {
        Validate.isTrue(size < Long.BYTES * 8, "size is too large");

        this.items = createArray(size);
        this.allBits = ((1L << size) - 1);
    }

    public boolean isCompletelyEmpty() {
        return this.bitSet == 0;
    }

    public boolean hasFullStacks() {
        return (this.bitSet & this.allBits) == allBits;
    }

    @Override
    public ItemStack set(int index, @NotNull ItemStack itemStack) {
        ItemStack existing = this.items[index];

        this.items[index] = itemStack;

        if (itemStack == ItemStack.EMPTY) {
            this.bitSet &= ~(1L << index);
        } else {
            this.bitSet |= 1L << index;
        }

        return existing;
    }

    @NotNull
    @Override
    public ItemStack get(int var0) {
        return this.items[var0];
    }

    @Override
    public int size() {
        return this.items.length;
    }

    @Override
    public void clear() {
        Arrays.fill(this.items, ItemStack.EMPTY);
    }

    // these are unsupported for block inventories which have a static size
    @Override
    public void add(int var0, ItemStack var1) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ItemStack remove(int var0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "ItemListWithBitset{" +
          "items=" + Arrays.toString(items) +
          ", bitSet=" + Long.toString(bitSet, 2) +
          ", allBits=" + Long.toString(allBits, 2) +
          ", size=" + this.items.length +
          '}';
    }
}
