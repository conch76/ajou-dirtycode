# ajou-dirtycode
Dirty code for refactoring

1. 먼저 test package를 생성하고 test에 필요한 몇가지 import를 수행했다.

2. 코드를 분석한 결과 
  item[].name이 Aged Brie일 때, Backstage passes to a TAFKAL80ETC concert일 때, Sulfuras, Hand of Ragnaros일 때와 그 외로 나뉘고
  item[].quality가 0이하, 0에서50사이, 50이상일 때로 나뉘고
  itme[].sellin이 0이하, 0에서6사이, 6에서11사이, 11이상일 때로 나뉘는 것을 알 수 있었다.
 
  이를 바탕으로 test code를 작성하였다.
  
3. refactoring은 다음과 같이 수행하였다.
  ㄴㅇㄻㄴㄹㄴㅁㅇㄹ
