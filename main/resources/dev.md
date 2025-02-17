## Open API key
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


## 

先能跑起来发个 promopt，再把他们能干的全干了

## 安装 llma 进去然后跑一下 “web scrapping"

Ollama 是一个 LLM 管理工具，它的核心功能是：
•	封装 Llama.cpp 运行环境，让用户 不用关心底层细节（如模型格式、量化、优化等）
Llama.cpp 是一个 C++ 实现的 LLM 推理引擎 ，目标是：
•	让大语言模型（LLM）在 低资源设备（如 CPU）上运行

## 现在我需要这个东西去爬一下 所有 resort 的网站，和未来下雪的预测

+ resort
+ resort twitter 
+ weather GPS (complicated)... fuck that shit 

## 第二步 

Need a better prediction tools, LLM isn't good at consuming raw html contents I guess?

Now I am thinking you scrap the html from the websites of the weather data -> LLM -> is it snowing the upcoming days
book or no book
Ok the LLM is not out putting the information I need.
I need to design a function to trigger once the LLM output the information and store it as structured data, how should I do it
Still didn't output the thing I want, but fuck it, let's move on

**
Prompting is the key to LLMs I think nowadays
Monitor Tweeter Feed
Determine if it's a snow shit



go get
## [TODO] let's have some fun give a function somewhere in this Java, from a prompt and trigger something

## In this case I don't need LLMs to do the stuff for me

Basically I can send in the weather GPS information,
and then place the parking either through Web automation / API directly


https://www.weather.gov/forecastpoints
108,166 is for SnowBird


## read about the langchain shit tonight see what kind of cool stuff it do
## How does the Mono Shit works? I don't understand let's read about it, espcially on reactive spring.



## Let's read about LangChain4J, before I drill down futhurer... this is stucking me 

貌似不能混着用？
Caused by: java.lang.NullPointerException: Cannot invoke "dev.langchain4j.service.spring.AiService.chatModel()" because "aiServiceAnnotation" is null
at dev.langchain4j.service.spring.AiServicesAutoConfig.lambda$aiServicesRegisteringBeanFactoryPostProcessor$0(AiServicesAutoConfig.java:101) ~[langchain4j-spring-boot-starter-1.0.0-beta1.jar:na]


Structured Outputs

SnowCard{
@Description
HeavyPowderDay
@Description("Critical issues such as payment gateway failures or security breaches.")
ModeratePowderDay
@Description("Critical issues such as payment gateway failures or security breaches.")
LightSnowDay
NoSnowDay
}

PriorityAnalyzer priorityAnalyzer = AiServices.create(PriorityAnalyzer.class, model);
Priority priority = priorityAnalyzer.analyzePriority("The main payment gateway is down, and customers cannot process transactions.");

For newer models that support Structured Outputs 


Loop through each response and set as object for for each object you feed into llm to give it a category 

What is a RAG



## Process
Structured Weather Data -> POJOS with description -> f
eed in the pojos -> 
Let AI to determine based on a system message -> Give it a ranking from 0 - 10

## 
Now with the ranked pojos, and feed into the MongoDB finish up the process 

I don't think i fucking need RAG today?


https://github.com/langchain4j/langchain4j-examples/blob/5c5fc14613101a84fe32b39200e30701fec45194/other-examples/src/main/java/OtherServiceExamples.java#L27

https://github.com/langchain4j/langchain4j-examples/blob/main/other-examples/src/main/java/embedding/classification/EmbeddingModelTextClassifierExample.java