package com.example.BankSystem.convertor;

import com.example.BankSystem.dto.CaedHolderDto.CardHolderRequestDto;
import com.example.BankSystem.dto.CaedHolderDto.CardHolderResponseDto;
import com.example.BankSystem.model.CardHolder;
import org.springframework.stereotype.Component;

@Component
public class CardHolderConvertor {
//    public CardHolderResponseDto convert(CardHolderRequestDto cardHolder){
//        return new CardHolderResponseDto( cardHolder.getCardHolderId(),
//                new CardConvertor().convert(cardHolder.getCard()),
//                new AccountConvertor().convert( cardHolder.getAccount()),
//                new AddressConvertor().convert( cardHolder.getAddress()));
//    }
//    public CardHolderResponseDto convert(CardHolder cardHolder){
//        return new CardHolderResponseDto( cardHolder.getCardHolderId(),
//                new CardConvertor().convert(cardHolder.getCard()),
//                new AccountConvertor().convert( cardHolder.getAccount()),
//                new AddressConvertor().convert( cardHolder.getAddress()));
//    }
    public CardHolderResponseDto convert(CardHolderRequestDto cardHolder){
        CardHolderResponseDto cardHolderResponseDto= new CardHolderResponseDto( cardHolder.getCardHolderId(),
                new CardConvertor().convert(cardHolder.getCard()),
                new AccountConvertor().convert( cardHolder.getAccount()),
                new AddressConvertor().convert( cardHolder.getAddress()));
        return cardHolderResponseDto;
    }
    public CardHolderResponseDto convert(CardHolder cardHolder){
        return new CardHolderResponseDto( cardHolder.getCardHolderId(),
                new CardConvertor().convert(cardHolder.getCard()),
                new AccountConvertor().convert( cardHolder.getAccount()),
                new AddressConvertor().convert( cardHolder.getAddress()));
    }


}
