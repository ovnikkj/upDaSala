import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: const MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  TextEditingController nomeC = TextEditingController();
  TextEditingController senhaC = TextEditingController();
  TextEditingController sexoC = TextEditingController();
  var mostrarSenha = false;
  
  var eyeChoosed = Icons.remove_red_eye_outlined;
  //Fim variaveis
  @override
  Widget build(BuildContext context) {
    
    return Scaffold(
      body: Center(
        child: Container(
          width: 450,height: 650,
          child: Column(children: [
            Text("Crie sua conta",style: TextStyle(fontSize: 30),),
TextFormField(controller: nomeC,decoration: InputDecoration(suffixIcon: Icon(Icons.person),enabledBorder: OutlineInputBorder(),label: Text("User:"),),),


TextFormField(validator: (value) {
  if (value == null || value.isEmpty) {
    print("vazio");
    return "preencha esse campo";
    
  }else{
    return null;
  }
}
,obscureText: !mostrarSenha,controller: senhaC,decoration: InputDecoration(suffixIcon: IconButton(icon: Icon(eyeChoosed),
onPressed: () {
  setState(() {
  mostrarSenha = !mostrarSenha;
  if (mostrarSenha){
    eyeChoosed = Icons.remove_red_eye_outlined;
    print(eyeChoosed);
  }else{
     eyeChoosed = Icons.remove_red_eye;
     print(eyeChoosed);
  }

  });
},

),enabledBorder: OutlineInputBorder(),label: Text("Senha:"),
),
),
ElevatedButton(onPressed: (){}, child: Text("Cadastrar"))
         
          ],),
        ),
      ),
    );
  }
}

