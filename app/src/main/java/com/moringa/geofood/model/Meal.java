
package com.moringa.geofood.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Meal {

    @SerializedName("idMeal")
    @Expose
    private String idMeal;
    @SerializedName("strMeal")
    @Expose
    private String strMeal;
//    @SerializedName("strDrinkAlternate")
//    @Expose
//    private Object strDrinkAlternate;
    @SerializedName("strCategory")
    @Expose
    private String strCategory;
    @SerializedName("strArea")
    @Expose
    private String strArea;
    @SerializedName("strInstructions")
    @Expose
    private String strInstructions;
    @SerializedName("strMealThumb")
    @Expose
    private String strMealThumb;
    @SerializedName("strTags")
    @Expose
    private String strTags;
    @SerializedName("strYoutube")
    @Expose
    private String strYoutube;
    @SerializedName("strIngredient1")
    @Expose
    private String strIngredient1;
    @SerializedName("strIngredient2")
    @Expose
    private String strIngredient2;
    @SerializedName("strIngredient3")
    @Expose
    private String strIngredient3;
    @SerializedName("strIngredient4")
    @Expose
    private String strIngredient4;
    @SerializedName("strIngredient5")
    @Expose
    private String strIngredient5;
    @SerializedName("strIngredient6")
    @Expose
    private String strIngredient6;
    @SerializedName("strIngredient7")
    @Expose
    private String strIngredient7;
    @SerializedName("strIngredient8")
    @Expose
    private String strIngredient8;
    @SerializedName("strIngredient9")
    @Expose
    private String strIngredient9;
    @SerializedName("strIngredient10")
    @Expose
    private String strIngredient10;
    @SerializedName("strIngredient11")
    @Expose
    private String strIngredient11;
    @SerializedName("strIngredient12")
    @Expose
    private String strIngredient12;
    @SerializedName("strIngredient13")
    @Expose
    private String strIngredient13;
    @SerializedName("strIngredient14")
    @Expose
    private String strIngredient14;
    @SerializedName("strIngredient15")
    @Expose
    private String strIngredient15;
    @SerializedName("strIngredient16")
    @Expose
    private String strIngredient16;
    @SerializedName("strIngredient17")
    @Expose
    private String strIngredient17;
    @SerializedName("strIngredient18")
    @Expose
    private String strIngredient18;
    @SerializedName("strIngredient19")
    @Expose
    private String strIngredient19;
    @SerializedName("strIngredient20")
    @Expose
    private String strIngredient20;
    @SerializedName("strMeasure1")
    @Expose
    private String strMeasure1;
    @SerializedName("strMeasure2")
    @Expose
    private String strMeasure2;
    @SerializedName("strMeasure3")
    @Expose
    private String strMeasure3;
    @SerializedName("strMeasure4")
    @Expose
    private String strMeasure4;
    @SerializedName("strMeasure5")
    @Expose
    private String strMeasure5;
    @SerializedName("strMeasure6")
    @Expose
    private String strMeasure6;
    @SerializedName("strMeasure7")
    @Expose
    private String strMeasure7;
    @SerializedName("strMeasure8")
    @Expose
    private String strMeasure8;
    @SerializedName("strMeasure9")
    @Expose
    private String strMeasure9;
    @SerializedName("strMeasure10")
    @Expose
    private String strMeasure10;
    @SerializedName("strMeasure11")
    @Expose
    private String strMeasure11;
    @SerializedName("strMeasure12")
    @Expose
    private String strMeasure12;
    @SerializedName("strMeasure13")
    @Expose
    private String strMeasure13;
    @SerializedName("strMeasure14")
    @Expose
    private String strMeasure14;
    @SerializedName("strMeasure15")
    @Expose
    private String strMeasure15;
    @SerializedName("strMeasure16")
    @Expose
    private String strMeasure16;
    @SerializedName("strMeasure17")
    @Expose
    private String strMeasure17;
    @SerializedName("strMeasure18")
    @Expose
    private String strMeasure18;
    @SerializedName("strMeasure19")
    @Expose
    private String strMeasure19;
    @SerializedName("strMeasure20")
    @Expose
    private String strMeasure20;
    @SerializedName("strSource")
    @Expose
    private String strSource;

    private String pushId;
//    @SerializedName("dateModified")
//    @Expose
//    private Object dateModified;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meal() {
    }

    /**
     * 
     * @param strIngredient10
     * @param strIngredient12
     * @param strIngredient11
     * @param strIngredient14
     * @param strCategory
     * @param strIngredient13
     * @param strIngredient16
     * @param strIngredient15
     * @param strIngredient18
     * @param strIngredient17
     * @param strArea
     * @param strIngredient19
     * @param strTags
     * @param idMeal
     * @param strInstructions
     * @param strIngredient1
     * @param strIngredient3
     * @param strIngredient2
     * @param strIngredient20
     * @param strIngredient5
     * @param strIngredient4
     * @param strIngredient7
     * @param strIngredient6
     * @param strIngredient9
     * @param strIngredient8
     * @param strMealThumb
     * @param strMeasure20
     * @param strYoutube
     * @param strMeal
     * @param strMeasure12
     * @param strMeasure13
     * @param strMeasure10
     * @param strMeasure11
//     * @param dateModified
//     * @param strDrinkAlternate
     * @param strSource
     * @param strMeasure9
     * @param strMeasure7
     * @param strMeasure8
     * @param strMeasure5
     * @param strMeasure6
     * @param strMeasure3
     * @param strMeasure4
     * @param strMeasure1
     * @param strMeasure18
     * @param strMeasure2
     * @param strMeasure19
     * @param strMeasure16
     * @param strMeasure17
     * @param strMeasure14
     * @param strMeasure15
     */
    public Meal(String idMeal, String strMeal, String strCategory, String strArea, String strInstructions, String strMealThumb, String strTags, String strYoutube, String strIngredient1, String strIngredient2, String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6, String strIngredient7, String strIngredient8, String strIngredient9, String strIngredient10, String strIngredient11, String strIngredient12, String strIngredient13, String strIngredient14, String strIngredient15, String strIngredient16, String strIngredient17, String strIngredient18, String strIngredient19, String strIngredient20, String strMeasure1, String strMeasure2, String strMeasure3, String strMeasure4, String strMeasure5, String strMeasure6, String strMeasure7, String strMeasure8, String strMeasure9, String strMeasure10, String strMeasure11, String strMeasure12, String strMeasure13, String strMeasure14, String strMeasure15, String strMeasure16, String strMeasure17, String strMeasure18, String strMeasure19, String strMeasure20, String strSource) {
        super();
        this.idMeal = idMeal;
        this.strMeal = strMeal;
//        this.strDrinkAlternate = strDrinkAlternate;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strTags = strTags;
        this.strYoutube = strYoutube;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
        this.strIngredient7 = strIngredient7;
        this.strIngredient8 = strIngredient8;
        this.strIngredient9 = strIngredient9;
        this.strIngredient10 = strIngredient10;
        this.strIngredient11 = strIngredient11;
        this.strIngredient12 = strIngredient12;
        this.strIngredient13 = strIngredient13;
        this.strIngredient14 = strIngredient14;
        this.strIngredient15 = strIngredient15;
        this.strIngredient16 = strIngredient16;
        this.strIngredient17 = strIngredient17;
        this.strIngredient18 = strIngredient18;
        this.strIngredient19 = strIngredient19;
        this.strIngredient20 = strIngredient20;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;
        this.strMeasure4 = strMeasure4;
        this.strMeasure5 = strMeasure5;
        this.strMeasure6 = strMeasure6;
        this.strMeasure7 = strMeasure7;
        this.strMeasure8 = strMeasure8;
        this.strMeasure9 = strMeasure9;
        this.strMeasure10 = strMeasure10;
        this.strMeasure11 = strMeasure11;
        this.strMeasure12 = strMeasure12;
        this.strMeasure13 = strMeasure13;
        this.strMeasure14 = strMeasure14;
        this.strMeasure15 = strMeasure15;
        this.strMeasure16 = strMeasure16;
        this.strMeasure17 = strMeasure17;
        this.strMeasure18 = strMeasure18;
        this.strMeasure19 = strMeasure19;
        this.strMeasure20 = strMeasure20;
        this.strSource = strSource;
//        this.dateModified = dateModified;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public Meal withIdMeal(String idMeal) {
        this.idMeal = idMeal;
        return this;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public Meal withStrMeal(String strMeal) {
        this.strMeal = strMeal;
        return this;
    }

//    public Object getStrDrinkAlternate() {
//        return strDrinkAlternate;
//    }
//
//    public void setStrDrinkAlternate(Object strDrinkAlternate) {
//        this.strDrinkAlternate = strDrinkAlternate;
//    }

//    public Meal withStrDrinkAlternate(Object strDrinkAlternate) {
//        this.strDrinkAlternate = strDrinkAlternate;
//        return this;
//    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public Meal withStrCategory(String strCategory) {
        this.strCategory = strCategory;
        return this;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public Meal withStrArea(String strArea) {
        this.strArea = strArea;
        return this;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public Meal withStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
        return this;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public Meal withStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
        return this;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public Meal withStrTags(String strTags) {
        this.strTags = strTags;
        return this;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public Meal withStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
        return this;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public Meal withStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
        return this;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public Meal withStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
        return this;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public Meal withStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
        return this;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public void setStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
    }

    public Meal withStrIngredient4(String strIngredient4) {
        this.strIngredient4 = strIngredient4;
        return this;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public void setStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
    }

    public Meal withStrIngredient5(String strIngredient5) {
        this.strIngredient5 = strIngredient5;
        return this;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public void setStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
    }

    public Meal withStrIngredient6(String strIngredient6) {
        this.strIngredient6 = strIngredient6;
        return this;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public void setStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
    }

    public Meal withStrIngredient7(String strIngredient7) {
        this.strIngredient7 = strIngredient7;
        return this;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public void setStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
    }

    public Meal withStrIngredient8(String strIngredient8) {
        this.strIngredient8 = strIngredient8;
        return this;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public void setStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
    }

    public Meal withStrIngredient9(String strIngredient9) {
        this.strIngredient9 = strIngredient9;
        return this;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public void setStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
    }

    public Meal withStrIngredient10(String strIngredient10) {
        this.strIngredient10 = strIngredient10;
        return this;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public void setStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
    }

    public Meal withStrIngredient11(String strIngredient11) {
        this.strIngredient11 = strIngredient11;
        return this;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public void setStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
    }

    public Meal withStrIngredient12(String strIngredient12) {
        this.strIngredient12 = strIngredient12;
        return this;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public void setStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
    }

    public Meal withStrIngredient13(String strIngredient13) {
        this.strIngredient13 = strIngredient13;
        return this;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public void setStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
    }

    public Meal withStrIngredient14(String strIngredient14) {
        this.strIngredient14 = strIngredient14;
        return this;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public void setStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
    }

    public Meal withStrIngredient15(String strIngredient15) {
        this.strIngredient15 = strIngredient15;
        return this;
    }

    public String getStrIngredient16() {
        return strIngredient16;
    }

    public void setStrIngredient16(String strIngredient16) {
        this.strIngredient16 = strIngredient16;
    }

    public Meal withStrIngredient16(String strIngredient16) {
        this.strIngredient16 = strIngredient16;
        return this;
    }

    public String getStrIngredient17() {
        return strIngredient17;
    }

    public void setStrIngredient17(String strIngredient17) {
        this.strIngredient17 = strIngredient17;
    }

    public Meal withStrIngredient17(String strIngredient17) {
        this.strIngredient17 = strIngredient17;
        return this;
    }

    public String getStrIngredient18() {
        return strIngredient18;
    }

    public void setStrIngredient18(String strIngredient18) {
        this.strIngredient18 = strIngredient18;
    }

    public Meal withStrIngredient18(String strIngredient18) {
        this.strIngredient18 = strIngredient18;
        return this;
    }

    public String getStrIngredient19() {
        return strIngredient19;
    }

    public void setStrIngredient19(String strIngredient19) {
        this.strIngredient19 = strIngredient19;
    }

    public Meal withStrIngredient19(String strIngredient19) {
        this.strIngredient19 = strIngredient19;
        return this;
    }

    public String getStrIngredient20() {
        return strIngredient20;
    }

    public void setStrIngredient20(String strIngredient20) {
        this.strIngredient20 = strIngredient20;
    }

    public Meal withStrIngredient20(String strIngredient20) {
        this.strIngredient20 = strIngredient20;
        return this;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public Meal withStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
        return this;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public Meal withStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
        return this;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }

    public Meal withStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
        return this;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public void setStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
    }

    public Meal withStrMeasure4(String strMeasure4) {
        this.strMeasure4 = strMeasure4;
        return this;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public void setStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
    }

    public Meal withStrMeasure5(String strMeasure5) {
        this.strMeasure5 = strMeasure5;
        return this;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public void setStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
    }

    public Meal withStrMeasure6(String strMeasure6) {
        this.strMeasure6 = strMeasure6;
        return this;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public void setStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
    }

    public Meal withStrMeasure7(String strMeasure7) {
        this.strMeasure7 = strMeasure7;
        return this;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public void setStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
    }

    public Meal withStrMeasure8(String strMeasure8) {
        this.strMeasure8 = strMeasure8;
        return this;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public void setStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
    }

    public Meal withStrMeasure9(String strMeasure9) {
        this.strMeasure9 = strMeasure9;
        return this;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public void setStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
    }

    public Meal withStrMeasure10(String strMeasure10) {
        this.strMeasure10 = strMeasure10;
        return this;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public void setStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
    }

    public Meal withStrMeasure11(String strMeasure11) {
        this.strMeasure11 = strMeasure11;
        return this;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public void setStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
    }

    public Meal withStrMeasure12(String strMeasure12) {
        this.strMeasure12 = strMeasure12;
        return this;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public void setStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
    }

    public Meal withStrMeasure13(String strMeasure13) {
        this.strMeasure13 = strMeasure13;
        return this;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public void setStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
    }

    public Meal withStrMeasure14(String strMeasure14) {
        this.strMeasure14 = strMeasure14;
        return this;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public void setStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
    }

    public Meal withStrMeasure15(String strMeasure15) {
        this.strMeasure15 = strMeasure15;
        return this;
    }

    public String getStrMeasure16() {
        return strMeasure16;
    }

    public void setStrMeasure16(String strMeasure16) {
        this.strMeasure16 = strMeasure16;
    }

    public Meal withStrMeasure16(String strMeasure16) {
        this.strMeasure16 = strMeasure16;
        return this;
    }

    public String getStrMeasure17() {
        return strMeasure17;
    }

    public void setStrMeasure17(String strMeasure17) {
        this.strMeasure17 = strMeasure17;
    }

    public Meal withStrMeasure17(String strMeasure17) {
        this.strMeasure17 = strMeasure17;
        return this;
    }

    public String getStrMeasure18() {
        return strMeasure18;
    }

    public void setStrMeasure18(String strMeasure18) {
        this.strMeasure18 = strMeasure18;
    }

    public Meal withStrMeasure18(String strMeasure18) {
        this.strMeasure18 = strMeasure18;
        return this;
    }

    public String getStrMeasure19() {
        return strMeasure19;
    }

    public void setStrMeasure19(String strMeasure19) {
        this.strMeasure19 = strMeasure19;
    }

    public Meal withStrMeasure19(String strMeasure19) {
        this.strMeasure19 = strMeasure19;
        return this;
    }

    public String getStrMeasure20() {
        return strMeasure20;
    }

    public void setStrMeasure20(String strMeasure20) {
        this.strMeasure20 = strMeasure20;
    }

    public Meal withStrMeasure20(String strMeasure20) {
        this.strMeasure20 = strMeasure20;
        return this;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public Meal withStrSource(String strSource) {
        this.strSource = strSource;
        return this;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

//    public Object getDateModified() {
//        return dateModified;
//    }
//
//    public void setDateModified(Object dateModified) {
//        this.dateModified = dateModified;
//    }
//
//    public Meal withDateModified(Object dateModified) {
//        this.dateModified = dateModified;
//        return this;
//    }

}
