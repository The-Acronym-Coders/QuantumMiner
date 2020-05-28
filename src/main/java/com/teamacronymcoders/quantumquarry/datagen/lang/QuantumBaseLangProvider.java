package com.teamacronymcoders.quantumquarry.datagen.lang;

import com.teamacronymcoders.quantumquarry.QuantumQuarry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class QuantumBaseLangProvider extends LanguageProvider {

    public QuantumBaseLangProvider(DataGenerator gen, String locale) {
        super(gen, QuantumQuarry.MODID, locale);
    }

    @Override
    protected void addTranslations() {}
}
