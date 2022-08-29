# Evaluation excercise

Source code for evaluation excercise for the recruitment process for Atipera company.


## QuickStart

Run application:

```
$ ./mvnw spring-boot:run
```

Evaluate application:

```
$ curl localhost:8080/show/zozola
[
    {"name":"atiperarecruitment","owner":"zozola",
    "branches":[{"name":"main","sha":"d393c47da07ceb3070105bc2b72ab84c47762203"}]},
    {"name":"intecarecruitment","owner":"zozola",
    "branches":[{"name":"main","sha":"2c61420c04c16f2820a0306a32e0d1ddf5dd86e0"}]},
    {"name":"tutorial00","owner":"zozola",
    "branches":[{"name":"main","sha":"74e186f6be76a7310642dfc939eb398e54f31bf5"}]}
]
```

Result json contains list of every given user repository.
For each repository list of branches is provided.
Only repositories that are not forks are shawn.