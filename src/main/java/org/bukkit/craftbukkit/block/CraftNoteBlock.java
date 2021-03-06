package org.bukkit.craftbukkit.block;

import net.minecraft.block.entity.NoteBlockBlockEntity;
import net.minecraft.util.math.BlockPos;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.block.NoteBlock;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.util.CraftMagicNumbers;

public class CraftNoteBlock extends CraftBlockState implements NoteBlock {
    private final CraftWorld world;
    private final NoteBlockBlockEntity note;

    public CraftNoteBlock(final Block block) {
        super(block);

        world = (CraftWorld) block.getWorld();
        note = (NoteBlockBlockEntity) world.getTileEntityAt(getX(), getY(), getZ());
    }

    public CraftNoteBlock(final Material material, final NoteBlockBlockEntity te) {
        super(material);
        world = null;
        note = te;
    }

    public Note getNote() {
        return new Note(note.field_1458);
    }

    public byte getRawNote() {
        return note.field_1458;
    }

    public void setNote(Note n) {
        note.field_1458 = n.getId();
    }

    public void setRawNote(byte n) {
        note.field_1458 = n;
    }

    public boolean play() {
        Block block = getBlock();

        if (block.getType() == Material.NOTE_BLOCK) {
            note.method_1175(world.getHandle(), new BlockPos(getX(), getY(), getZ()));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean play(byte instrument, byte note) {
        Block block = getBlock();

        if (block.getType() == Material.NOTE_BLOCK) {
            world.getHandle().addBlockAction(new BlockPos(getX(), getY(), getZ()), CraftMagicNumbers.getBlock(block), instrument, note);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean play(Instrument instrument, Note note) {
        Block block = getBlock();

        if (block.getType() == Material.NOTE_BLOCK) {
            world.getHandle().addBlockAction(new BlockPos(getX(), getY(), getZ()), CraftMagicNumbers.getBlock(block), instrument.getType(), note.getId());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public NoteBlockBlockEntity getTileEntity() {
        return note;
    }
}
