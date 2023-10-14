package com.Optimus.studentlaibraymangment.tansformer;


import com.Optimus.studentlaibraymangment.Enum.CardStatus;
import com.Optimus.studentlaibraymangment.entity.LibraryCard;

import java.sql.Date;
import java.util.UUID;

public class LibraryCardTranformer {

    public  static LibraryCard PreparingLibraryCard(){
        return LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.Active)
                .build();
    }
}
