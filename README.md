# 아주대학교 실전코딩 12조 Refactoring Assignment Report
## Junit Test 
테스트조건문을 분석해본결과 Item 객체의 name 속성은 총 4가지 경우(Sulfuras, Hand of Ragnaros, Sulfuras, Hand of Ragnaros, Sulfuras, Hand of Ragnaros, 그외 문자열)가 있고 
이는 updateQuality() 에서 변하지 않으므로 Item.name을 기준으로 test case를 만들었습니다. Item.sellIn과 Item.quality 값은 updateQuality()내에서 변할 수 있고 if 조건문의 
Item.sellIn과 Item.quality에 대한 조건들을 기준으로 lower bound와 upper bound를 개인적으로 정하였습니다. 이렇게 한 이유는 test case들을 뽑아낼때 자신이 짠 코드도 아니고
if 조건문이 중첩되어 있어서 모든 경우의 수를 뽑아내지 못할 가능성이 높기 때문입니다. 따라서 모든 경우의 수를 만족하고 의미있는 lower bound와 upper bound를 설정하여 같은 
Item배열 2개를 리팩토링 안된
DirtySample class와 Refactoring된 DirtySample class의 updateQuality() 메소드 parameter로 넘겨주어 두 배열 원소들을 1대1로 같은지 비교하는 unit test를 만들었습니다.
```java 
for(int i=-2; i<14 ; i++) {
    for(int j=0; j<54; j++) {
        legacyTestItems[j] = new Item("Aged Brie", i, j-2);
        refactoringTestItems[j] = new Item("Aged Brie", i, j-2);
    }
    new DirtySample(refactoringTestItems).updateQuality();
    new OriginalDirtySample(legacyTestItems).updateQuality();
    for(int j=0; j<54; j++){
        assertEquals(legacyTestItems[j].sellIn, refactoringTestItems[j].sellIn);
        assertEquals(legacyTestItems[j].quality, refactoringTestItems[j].quality);
       
    }
}
```
##  Refactoring Process
- name이 "Sulfuras, Hand of Ragnaros"이 아닌 경우와 "Sulfuras, Hand of Ragnaros"인 경우로 if문 단순화
- 조건문을 isAgedBrieOrBackstagePasses() 메소드로 extract 
- 
```java
if (items[i].quality < 50) {
                       items[i].quality = items[i].quality + 1;
   
                       if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                           if (items[i].sellIn < 11) {
                               if (items[i].quality < 50) {
                                   items[i].quality = items[i].quality + 1;
                               }
                           }
   
                           if (items[i].sellIn < 6) {
                               if (items[i].quality < 50) {
                                   items[i].quality = items[i].quality + 1;
                               }
                           }
                       }
                   }
```
를 isItemQualityLessThan50() 메소드로 extract

- items[i].quality = items[i].quality + 1; 를 addIntegerToQuality() 메소드로 extract
-
```java 
if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
```
를 isItemSellInNegative() 메소드로 extract

- `items[i].name.equals("Aged Brie")`를 nameIs()메소드로 extract

