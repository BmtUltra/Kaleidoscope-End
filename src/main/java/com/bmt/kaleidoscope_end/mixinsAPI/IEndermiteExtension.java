package com.bmt.kaleidoscope_end.mixinsAPI;

import com.bmt.kaleidoscope_end.common.KEEndermiteInfo;
import net.minecraft.world.entity.monster.Endermite;

public interface IEndermiteExtension {
     KEEndermiteInfo ke$getEndermiteInfo();

     static KEEndermiteInfo getInfo(Endermite endermite){
         return ((IEndermiteExtension) endermite).ke$getEndermiteInfo();
     }
}
