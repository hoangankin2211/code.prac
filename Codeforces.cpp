#include<iostream>
#include<math.h>
#include<vector>
using namespace std;

class Food{
private:
    string name;
    double price;
    
public:
    Food(){}
    
    Food(string name,double price) : name(name),price(price){};
    
    void setName(string name){
        this->name=name;
    }
    
    string getName(){
        return name;
    }
    
    void setPrice(double price){
        this->price = price;
    }
    
    double getPrice(){
        return price;
    }
    void display(){
        cout<<"Name: "<<name<<endl;
        cout<<"Price: "<<price<<endl;
    }
};

class CannedFood : public Food{
private:
    int numberBox;
public:
    CannedFood(){}
    
    CannedFood(string name,double price, int nunberBox) : Food(name,price),numberBox(numberBox){}

    void display(){
        Food::display();
        cout<<"Number Box: "<<numberBox;
    }
    
    void setNumberBox(int numberBox){
        this->numberBox=numberBox;
    }
    
    int getNumberBox(){
        return numberBox;
    }
    
    static void sortNumberBox(vector<CannedFood> &vt){
        for (int i=0;i<vt.size()-1;i++){
            for (int j=i;j<vt.size();j++){
                if (vt[i].getNumberBox() > vt[j].getNumberBox()){
                    CannedFood temp = vt[i];
                    vt[i] = vt[j];
                    vt[j]=temp;    
                }
            }
        }
    }
};

class NonCFood : public Food{
private:
    double weight;
public:
    NonCFood(){};
    
    NonCFood(string name,double price, double weight) : Food(name,price),weight(weight){}
    
    void display(){
        Food::display();
        cout<<"Weight: "<<weight;
    }
    
    void setWeight(double weight){
        this->weight = weight;
    }
    
    double getWeight(){
        return weight;
    }
    
    static void sortWeight(vector<NonCFood> &vt){
        for (int i=0;i<vt.size()-1;i++){
            for (int j=i;j<vt.size();j++){
                if (vt[i].getWeight() > vt[j].getWeight()){
                    NonCFood temp = vt[i];
                    vt[i]=vt[j];
                    vt[j]=temp;
                }
            }
        }
    }
};



int main(){
    NonCFood cf("Coffee",100,3);
    cf.display();
}