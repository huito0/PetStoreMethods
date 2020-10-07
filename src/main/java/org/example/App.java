package org.example;

public class App 
{
    public static void main( String[] args ) {
        PetStoreMethods petStore = new PetStoreMethods();

        System.out.println("Создание животного");
        petStore.addNewPet();

        System.out.println("Обновление животного в магазине");
        petStore.updatePet();

        System.out.println("Поиск животного");
        petStore.findPetByStatus();

        System.out.println("Удаление животного");
        petStore.deletePet(123456789);

        System.out.println("Проверка животного после удаления");
        petStore.findPetByStatus();

    }
}
